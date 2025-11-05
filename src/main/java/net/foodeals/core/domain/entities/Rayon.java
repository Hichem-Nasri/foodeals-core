package net.foodeals.core.domain.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UuidGenerator;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "rayon")

@NoArgsConstructor
@Getter

public class Rayon extends AbstractEntity<UUID> {

	@Id
	@GeneratedValue
	@UuidGenerator
	private UUID id;

	private String name;

	@OneToMany(mappedBy = "rayon", cascade = CascadeType.ALL)
	private List<Product> products;

	public Rayon(UUID id, String name) {
		this.id = id;
		this.name = name;
	}

	public  Rayon setName(String name) {
		this.name = name;
		return this;
	}
	
	public Rayon(String name) {

		this.name = name;
	}

	public static Rayon create(UUID id, String name) {
		return new Rayon(id, name);
	}
	
	public static Rayon create(String name) {
		return new Rayon(name);
	}
    
	public Rayon setProducts(List<Product> products) {
		this.products = products;
		return this;
	}
}
