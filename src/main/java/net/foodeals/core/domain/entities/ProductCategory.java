package net.foodeals.core.domain.entities;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import org.hibernate.annotations.UuidGenerator;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "product_categories")

@NoArgsConstructor
@Getter
public class ProductCategory extends AbstractEntity<UUID> {

	@Id
	@GeneratedValue
	@UuidGenerator
	private UUID id;

	private String name;

    private String imagePath;


    private String description;

	private String slug;

    private String icon;

    private Integer orderNo;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Activity activity;

	@OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
	private List<Product> products;
	
	@OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
	private List<ProductSubCategory> subCategories;

	public ProductCategory(String name, String slug) {
		this.name = name;
		this.slug = slug;
	}

	public ProductCategory(UUID id, String name, String slug) {
		this.id = id;
		this.name = name;
		this.slug = slug;
	}

    public ProductCategory(UUID id, String name, String slug, String description,String imagePath,String icon,Integer orderNo) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.imagePath = imagePath;
        this.icon = icon;
        this.orderNo = orderNo;
        this.slug = slug;
    }

	public static ProductCategory create(UUID id, String name,  String slug) {
		return new ProductCategory(name, slug);
	}

    public static ProductCategory create(UUID id, String name,  String slug ,String description,
                                         String imagePath,String icon,Integer orderNo) {
        return new ProductCategory(id,name,slug,description,imagePath,icon,orderNo);
    }

	public static ProductCategory create(String name, String slug) {
		return new ProductCategory(name, slug);
	}

	public ProductCategory setName(String name) {
		this.name = name;
		return this;
	}

	public ProductCategory setSlug(String slug) {
		this.slug = slug;
		return this;
	}

	public ProductCategory setProducts(List<Product> products) {
		this.products = products;
		return this;
	}
}
