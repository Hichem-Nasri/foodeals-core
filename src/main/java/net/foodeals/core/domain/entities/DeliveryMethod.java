package net.foodeals.core.domain.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Table(name = "delivery_methods")
@NoArgsConstructor
@Getter
public class DeliveryMethod extends AbstractEntity<UUID> {

	@Id
	@GeneratedValue
	private UUID id;

	@Column(nullable = false)
	private String deliveryName;

	public DeliveryMethod(UUID id, String deliveryName) {
		this.id = id;
		this.deliveryName = deliveryName;
	}

	public DeliveryMethod(String deliveryName) {
		this.deliveryName = deliveryName;
	}

	public static DeliveryMethod create(UUID id, String deliveryName) {
		return new DeliveryMethod(id, deliveryName);
	}

	public static DeliveryMethod create(String deliveryName) {
		return new DeliveryMethod(deliveryName);
	}

	public DeliveryMethod setDeliveryName(String deliveryName) {
		this.deliveryName = deliveryName;
		return this;
	}

}
