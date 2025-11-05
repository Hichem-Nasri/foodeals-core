package net.foodeals.core.domain.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import net.foodeals.core.domain.enums.SupplementCategory;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Entity
@Table(name = "supplements")
@Getter
@Setter
public class Supplement extends AbstractEntity<UUID> {

    @Id
    @GeneratedValue
    @UuidGenerator
    private UUID id;

    private String name;

    @Embedded
    private Price price;
    
    @Column(name = "supplement_image_type")
    private String supplementImagePath;

   
    @ManyToOne(fetch = FetchType.LAZY)
    private Deal deal;
    
    @ManyToOne(fetch = FetchType.LAZY)
    private Box box;

    @Enumerated(EnumType.STRING)
    private SupplementCategory supplementCategory ;

    public Supplement() {
    }

    public Supplement(String name, Price price,String supplementImagePath) {
        this.name = name;
        this.price = price;
        this.supplementImagePath=supplementImagePath;
    }
}