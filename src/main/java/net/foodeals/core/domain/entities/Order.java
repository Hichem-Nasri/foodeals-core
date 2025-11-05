package net.foodeals.core.domain.entities;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import net.foodeals.core.domain.enums.OrderSource;
import net.foodeals.core.domain.enums.OrderStatus;
import net.foodeals.core.domain.enums.OrderType;
import org.hibernate.annotations.UuidGenerator;
import org.springframework.lang.Nullable;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "orders")
@Getter
public class Order extends AbstractEntity<UUID> {

	@Id
	@GeneratedValue
	@UuidGenerator
	private UUID id;

	@Enumerated(EnumType.STRING)
	@Column(name = "order_type")
	private OrderType type;

	@Nullable
	private LocalTime collectionStartTime ;

	private LocalTime collectionEndTime;

    @ManyToOne(fetch = FetchType.LAZY) // NOUVEAU: donate, pas de CascadeType.ALL
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Donate donate;


	@Enumerated(EnumType.STRING)
	private OrderStatus status;

	@ManyToOne(cascade = CascadeType.ALL)
	private User client;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private SubEntity clientPro;

	@ManyToOne(cascade = CascadeType.ALL)
	private Offer offer;

	@ManyToOne(cascade = CascadeType.ALL)
	private Address shippingAddress;

	@OneToOne(cascade = CascadeType.ALL)
	private Delivery delivery;

	@ManyToOne(cascade = CascadeType.ALL)
	private Coupon coupon;
	
	private Integer quantity ;
	
	private Integer quantityOfOrder;

	@OneToOne(cascade = CascadeType.ALL)
	private Transaction transaction;

	@Column(name = "cancellation_reason")
	private String cancellationReason;

	@Column(name = "cancellation_subject")
	private String cancellationSubject;

	@Column(name = "cancellation_date")
	private LocalDateTime cancellationDate;

	@Column(name = "attachment_path")
	private String attachmentPath;

	@Enumerated(EnumType.STRING)
	private OrderSource orderSource;
	
	private boolean seen ;
	
	private boolean donation;

    private String additionalInformation;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderStatusHistory> statusHistory = new ArrayList<>();


    @Column(nullable = false)
    private double subtotal;

    @Column(nullable = false)
    private double tax;

    @Column(nullable = false)
    private double discount;

    @Column(nullable = false)
    private double total;


    public Order() {
	}

	public Order(OrderType type, OrderStatus status, User client, Offer offer) {
		this.type = type;
		this.status = status;
		this.client = client;
		this.offer = offer;
	}

	public static Order create(OrderType type, OrderStatus status, User client, Offer offer) {
		return new Order(type, status, client, offer);
	}

	public Order setOrderType(OrderType orderType) {
		this.type = orderType;
		return this;
	}

	public Order setOrderSource(OrderSource orderSource) {
		this.orderSource = orderSource;
		return this;
	}

	public Order setStatus(OrderStatus orderStatus) {
		this.status = orderStatus;
		return this;
	}

	public Order setShippingAddress(Address address) {
		this.shippingAddress = address;
		return this;
	}

	public Order setClient(User client) {
		this.client = client;
		return this;
	}
	
	public Order setClientPro(SubEntity clientPro) {
		this.clientPro = clientPro;
		return this;
	}

	public Order setOffer(Offer offer) {
		this.offer = offer;
		return this;
	}

	public Order setDelivery(Delivery delivery) {
		this.delivery = delivery;
		return this;
	}

	public Order setCoupon(Coupon coupon) {
		this.coupon = coupon;
		return this;
	}

	public Order setTransaction(Transaction transaction) {
		this.transaction = transaction;
		return this;
	}

	public Order setCancellationReason(String cancellationReason) {
		this.cancellationReason = cancellationReason;
		return this;
	}

	public Order setCancellationSubject(String cancellationSubject) {
		this.cancellationSubject = cancellationSubject;
		return this;
	}

	public Order setCancellationDate(LocalDateTime cancellationDate) {
		this.cancellationDate = cancellationDate;
		return this;
	}

	public Order setAttachmentPath(String attachmentPath) {
		this.attachmentPath = attachmentPath;
		return this;
	}
	
	public Order setQuantity(Integer quantity) {
		this.quantity = quantity;
		return this;
	}
	
	public Order setQuantityOfOrder(Integer quantityOfOrder) {
		this.quantityOfOrder = quantityOfOrder;
		return this;
	}

	public Order setSeen(boolean seen) {
		this.seen = seen;
		return this;
	}


	public Order setCollectionStartTime(LocalTime collectionStartTime) {
		this.collectionStartTime = collectionStartTime;
		return this;
	}

	public Order setCollectionEndTime(LocalTime collectionEndTime) {
		this.collectionEndTime = collectionEndTime;
		return this;
	}

    public void setTotal(double total) {
        this.total = total;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public void setStatusHistory(List<OrderStatusHistory> statusHistory) {
        this.statusHistory = statusHistory;
    }

    public void setAdditionalInformation(String additionalInformation) {
        this.additionalInformation = additionalInformation;
    }

    public void setType(OrderType type) {
        this.type = type;
    }
}
