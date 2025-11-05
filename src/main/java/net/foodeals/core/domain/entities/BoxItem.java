package net.foodeals.core.domain.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Entity
@Table(name = "box_items")

@Getter
@Setter
public class BoxItem extends AbstractEntity<UUID> {

    @Id
    @GeneratedValue
    @UuidGenerator
    private UUID id;

    @Embedded
    private Price price;

    private Integer quantity;

    @ManyToOne(cascade = CascadeType.ALL)
    private Box box;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Product product;

    BoxItem() {
    }

    public BoxItem(Price price, Integer quantity, Box box, Product product) {
        this.price = price;
        this.quantity = quantity;
        this.box = box;
        this.product = product;
    }

    public static BoxItem create(Price price, Integer quantity, Box box, Product product) {
        return new BoxItem(
                price,
                quantity,
                box,
                product
        );
    }
    
    public BoxItem(Price price, Integer quantity, Product product) {
        this.price = price;
        this.quantity = quantity;
        this.product = product;
    }

    public static BoxItem create(Price price, Integer quantity, Product product) {
        return new BoxItem(
                price,
                quantity,
                product
        );
    }
    
    
}
