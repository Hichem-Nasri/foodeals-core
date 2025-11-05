package net.foodeals.core.domain.entities;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import net.foodeals.core.domain.enums.*;
import org.hibernate.annotations.UuidGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "donates")
@Getter
@Setter
public class Donate extends AbstractEntity<UUID>{

    @Id
    @GeneratedValue
    @UuidGenerator
    private UUID id;

    @OneToOne(cascade = CascadeType.ALL)
    private DonateItems donateItems ;


    @ManyToOne(cascade = CascadeType.ALL)
    private OrganizationEntity donor;

    @ManyToOne(cascade = CascadeType.ALL)
    private User userDonor ;

    @ManyToOne(cascade = CascadeType.ALL)
    private OrganizationEntity receiver ;

    private ModalityType modalityType;

    private ModalityPaiement modalityPaiement;

    @Enumerated(EnumType.STRING)
    private DonateStatus donateStatus ;

    @Enumerated(EnumType.STRING)
    private DonationType donationType ;

    @Enumerated(EnumType.STRING)
    private DonateUnity donationUnity ;

    @Enumerated(EnumType.STRING)
    private DonateDeliveryMethod donateDelivryMethod ;

    private Long deliveryFee;

    private Double  amount ;

    @OneToMany(fetch=FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = false)
    private List<OpenTime> openTime;

    @OneToMany(fetch=FetchType.LAZY, mappedBy = "donate", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Order> orders = new ArrayList<>();

    private String motif;

    private String reason ;

    private String attechementFilePath ;

    private Boolean isAnonymous;



}
