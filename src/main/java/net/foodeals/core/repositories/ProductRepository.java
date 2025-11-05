package net.foodeals.core.repositories;

import net.foodeals.core.domain.entities.Product;
import net.foodeals.core.domain.entities.ProductCategory;
import net.foodeals.core.domain.entities.SubEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.Instant;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ProductRepository extends BaseRepository<Product, UUID> {

    @Query("SELECT p FROM Product p WHERE p.barcode = ?1 AND p.deletedAt IS NULL")
    public Optional<Product> findByBarcode(String barcode);

    @Query("SELECT p FROM Product p WHERE p.name ILIKE CONCAT(?1, '%') AND p.deletedAt IS NULL")
    public Page<Product> findProductsByName(String name, Pageable pageable);

    @Query("""
                SELECT p FROM Product p
                WHERE (:name IS NULL OR p.name ILIKE CONCAT(:name, '%'))
                  AND (:brand IS NULL OR p.brand = :brand)
                  AND (:categoryId IS NULL OR p.category.id = :categoryId)
                  AND (:subCategoryId IS NULL OR p.subcategory.id = :subCategoryId)
                  AND (:barcode IS NULL OR p.barcode = :barcode)
                  AND (:userId IS NULL OR p.createdBy.id = :userId)
                  AND (:startDate IS NULL OR p.createdAt >= :startDate)
                  AND (:endDate IS NULL OR p.createdAt <= :endDate)
            """)
    Page<Product> searchProducts(@Param("name") String name, @Param("brand") String brand, @Param("categoryId") UUID categoryId, @Param("subCategoryId") UUID subCategoryId, @Param("barcode") String barcode, @Param("userId") Integer userId, @Param("startDate") Instant startDate, @Param("endDate") Instant endDate, Pageable pageable);



    // Obtenir les produits triés par catégorie
    @Query("""
                SELECT p
                FROM Product p
                WHERE p.category.id = :categoryId AND p.subEntity.id = :subEntityId
            """)
    List<Product> findByCategoryAndSubEntity(UUID categoryId, UUID subEntityId);


    List<Product> findByCategoryAndIdNot(ProductCategory category, UUID id);

    List<Product> findBySubEntity(SubEntity subEntity);

    // Produits liés dans le même store (exclure le produit courant)
    List<Product> findBySubEntityAndIdNot(SubEntity subEntity, UUID excludedId);


    Collection<Product> findTop10ByNameContainingIgnoreCase(String query);

    Collection<Product> searchByNameContainingIgnoreCase(String q);  @Query("""
    SELECT p
    FROM Product p
    LEFT JOIN Deal d ON d.product.id = p.id AND d.dealStatus = 'AVAILABLE'
    WHERE d.offer.subEntity.id = :subEntityId
""")
    List<Product> findProductsWithActiveOffers(UUID subEntityId);
}
