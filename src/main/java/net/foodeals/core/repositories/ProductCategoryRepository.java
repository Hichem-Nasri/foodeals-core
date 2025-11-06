package net.foodeals.core.repositories;

import net.foodeals.core.domain.entities.ProductCategory;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ProductCategoryRepository extends BaseRepository<ProductCategory, UUID> {

	@Query("SELECT c FROM ProductCategory c WHERE c.name = :name AND c.deletedAt IS NULL")
	public Optional<ProductCategory>  findByName(String name);

	@Query("SELECT c FROM ProductCategory c  JOIN c.products p where p.id=:productId")
	public Optional<ProductCategory>  findByProduct(UUID productId);
	
	@Query("SELECT c FROM ProductCategory c WHERE c.slug = :slug AND c.deletedAt IS NULL")
    Optional<ProductCategory> findBySlug(String slug);

    @Query("SELECT c.id as id, c.name as name, c.description as description, c.imagePath as image, COUNT(p) as itemsCount, c.icon as icon, c.orderNo as orderNo " +
            "FROM ProductCategory c LEFT JOIN Product p ON p.category = c AND p.subEntity.id = :storeId " +
            "GROUP BY c.id, c.name, c.description, c.imagePath, c.icon, c.orderNo ORDER BY c.orderNo ASC")
    List<Object[]> findCategoriesWithCountsRaw(@Param("storeId") UUID storeId);



	
	/*@Query("SELECT new net.foodeals.dto.CategoryWithOffersDTO(pc.name, pc.isFavorite) FROM ProductCategory pc WHERE pc.subentity.id = :subentityId")
    List<CategoryWithOffersDTO> getCategoriesWithActiveOffers(@Param("subentityId") UUID subentityId);
    
	@Query("SELECT new net.foodeals.dto.ProductCategoryDTO(pc.name, p) FROM ProductCategory pc JOIN pc.products p WHERE pc.subentity.id = :subentityId")
    List<ProductCategoryDTO> getProductsByCategory(@Param("subentityId") UUID subentityId);*/


	@Query("""
        SELECT DISTINCT c.name
        FROM SubEntityProductCategory c
        JOIN c.subEntityDomain d
        WHERE :subEntityId IN (SELECT subEntity.id FROM SubEntityProductCategory subEntity)
    """)
	List<String> findActiveCategoryNamesBySubEntity(UUID subEntityId);

	@Query("""
        SELECT c
        FROM ProductCategory c
        JOIN c.products p
        WHERE p.subEntity.id = :subEntityId
    """)
	List<ProductCategory> findCategoriesBySubEntity(UUID subEntityId);


}

