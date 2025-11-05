package net.foodeals.core.domain.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UuidGenerator;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "product_brand")

@NoArgsConstructor
@Getter
public class ProductBrand extends AbstractEntity<UUID> {

	@Id
	@GeneratedValue
	@UuidGenerator
	private UUID id;

	private String name;

	private String slug;

	@OneToMany(mappedBy = "brand", cascade = CascadeType.ALL)
	private List<Product> products;
	
	public ProductBrand(String name, String slug) {
		this.name = name;
		this.slug = slug;
	}
	
	public ProductBrand(UUID id,String name, String slug) {
		this.id=id;
		this.name = name;
		this.slug = slug;
	}


	public static ProductBrand create(UUID id ,String name, String slug) {
		return new ProductBrand(id,name, slug);
	}
	
	public static ProductBrand create(String name, String slug) {
		return new ProductBrand(name, slug);
	}

	public ProductBrand setName(String name) {
		this.name = name;
		return this;
	}

	public ProductBrand setSlug(String slug) {
		this.slug = slug;
		return this;
	}

	public ProductBrand setProducts(List<Product> products) {
		this.products = products;
		return this;
	}

	

}
