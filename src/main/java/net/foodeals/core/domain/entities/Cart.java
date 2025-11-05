package net.foodeals.core.domain.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "carts")
@Getter
@Setter
public class Cart extends AbstractEntity<UUID>{
    
	@Id
    @GeneratedValue
    @UuidGenerator
    private UUID id;

    @Column(nullable = false)
    private Integer userId;

    private String timeSlot;

    private String subEntityAddress;

    private boolean isDonation;

    private boolean showInfoDonation;

    @Column(name = "client_address")
    private String clientAddress;

    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<CartItem> items=new ArrayList<>();

    public Cart() {}

    public Cart(Integer userId) {
        this.userId = userId;
    }
    
}
