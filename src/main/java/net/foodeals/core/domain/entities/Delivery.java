package net.foodeals.core.domain.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import net.foodeals.core.domain.enums.DeliveryStatus;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Entity
@Table(name = "deliveries")

@Getter
@Setter
public class Delivery extends AbstractEntity<UUID> {

	@Id
	@GeneratedValue
	@UuidGenerator
	private UUID id;

	@ManyToOne(cascade = CascadeType.ALL)
	private User deliveryBoy;

	private Integer rating;

	@Enumerated(EnumType.STRING)
	private DeliveryStatus status;

	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	private DeliveryPosition deliveryPosition;

	@OneToOne(mappedBy = "delivery", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	private Order order;

	private Long duration;

	public Delivery() {

	}

	public Delivery(User deliveryBoy, DeliveryStatus status) {
		this.deliveryBoy = deliveryBoy;
		this.status = status;
	}

	public static Delivery create(User deliveryBoy, DeliveryStatus status) {
		return new Delivery(deliveryBoy, status);
	}

}
