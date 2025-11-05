package net.foodeals.core.domain.entities;


import jakarta.persistence.*;
import lombok.*;
import net.foodeals.core.domain.enums.OrderStatus;

import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "order_status_history")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class OrderStatusHistory extends  AbstractEntity<UUID> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private Order order;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private OrderStatus status;

    @Column(nullable = false)
    private Instant timestamp;
}

