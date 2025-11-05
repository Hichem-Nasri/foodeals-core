package net.foodeals.core.domain.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "coupons")

@Getter
@Setter
public class Coupon extends AbstractEntity<UUID> {

    @Id
    @GeneratedValue
    @UuidGenerator
    private UUID id;

    private String code;

    private String name;

    private Float discount;

    @ManyToOne
    private User user ;

    @ManyToOne(fetch = FetchType.LAZY)
    private SubEntity subEntity;

    @Column(name = "ends_at")
    private Date endsAt;

    @Column(name = "is_enabled")
    private Boolean isEnabled;

   /* @OneToMany(mappedBy = "coupon", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Order> orders;*/

    public Coupon() {

    }

    public void toggleIsEnabled() {
        isEnabled = !isEnabled;
    }
}
