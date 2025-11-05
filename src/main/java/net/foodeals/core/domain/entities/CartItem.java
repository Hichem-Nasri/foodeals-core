package net.foodeals.core.domain.entities;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import net.foodeals.core.domain.enums.ModalityType;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Entity
@Table(name = "cart_items")
@Getter
@Setter
public class CartItem extends AbstractEntity<UUID>{


    @Id
    @GeneratedValue
    @UuidGenerator
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "cart_id", nullable = false)
    private Cart cart;

    @ManyToOne
    @JoinColumn(name = "deal_id", nullable = true)
    private Deal deal;

    @ManyToOne
    @JoinColumn(name = "box_id", nullable = true)
    private Box box;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = true)
    private Product product;

    @ManyToOne
    @JoinColumn(name = "subentity_id", nullable = true) // <-- ajout SubEntity si tu veux le rattacher
    private SubEntity subEntity;

    @Column(nullable = false)
    private Integer quantity;

    @Enumerated(EnumType.STRING)
    private ModalityType modalityType;

    private boolean selected=false;

    public CartItem() {}

    public CartItem(Cart cart, Deal deal, Integer quantity, ModalityType modalityType) {
        this.cart = cart;
        this.deal = deal;
        this.quantity = quantity;
        this.modalityType = modalityType;
    }

    public CartItem(Cart cart, Box box, Integer quantity, ModalityType modalityType) {
        this.cart = cart;
        this.box = box;
        this.quantity = quantity;
        this.modalityType = modalityType;
    }

    public CartItem(Cart cart, Product product, Integer quantity, ModalityType modalityType) {
        this.cart = cart;
        this.product = product;
        this.quantity = quantity;
        this.modalityType = modalityType;
    }

    // ⚡️ Ajout d’un champ calculé
    @Transient
    public String getCollectionInfo() {
        if (modalityType == null) return "UNKNOWN modality";
        return switch (modalityType) {
            case PICKUP -> "PICKUP - Available for pickup at store";
            case DELIVERY -> "DELIVERY - Will be delivered to your address";
            case AT_PLACE -> "ONSITE - Consume on location";
        };
    }
}

