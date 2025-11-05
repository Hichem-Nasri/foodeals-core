package net.foodeals.core.domain.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import net.foodeals.core.domain.enums.ProductType;
import org.hibernate.annotations.UuidGenerator;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "products")

@Getter
@Setter
public class Product extends AbstractEntity<UUID> {

    @Id
    @GeneratedValue
    @UuidGenerator
    private UUID id;

    private String name;

    private String slug;

    private String description;

    private String title;

    private String barcode;

    @Column(name = "product_type")
    private ProductType type;

    @Enumerated(EnumType.STRING)
    @Embedded
    private Price price;

    @Column(name = "product_image_type")
    private String ProductImagePath;

    @ManyToOne(cascade = CascadeType.ALL)
    private ProductCategory category;

    @ManyToOne(cascade = CascadeType.ALL)
    private ProductSubCategory subcategory;
    
    @Column(name = "brand")
    private String brand;

    @Column(name = "rayon")
    private String rayon ;
    
    @ManyToOne(cascade = CascadeType.ALL)
    private PaymentMethodProduct paymentMethodProduct;

    @ManyToOne(cascade = CascadeType.ALL)
    private DeliveryMethod deliveryMethod;
    
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<PickupCondition> pickupConditions;
    
    private String reason ;
    
    private String motif;
    
    @ManyToOne(cascade = CascadeType.ALL)
    private User createdBy;
    
    private Date expirationDate ;

    @ManyToOne
    private SubEntity subEntity ;

    private Integer stock= 0 ;

    @ManyToMany
    private List<Box>box=new ArrayList<>();
    

}