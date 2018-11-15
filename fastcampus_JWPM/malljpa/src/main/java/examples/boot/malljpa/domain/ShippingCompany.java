package examples.boot.malljpa.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "shipping_company")
@Getter
@Setter
public class ShippingCompany {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 50, nullable = false)
    private String corporateRegistrationNum;
    @Column(length = 50, nullable = false)
    private String callNum;
    @Column(length = 50, nullable = false)
    private String address;
    @Column(length = 50, nullable = false)
    private String accountNum;
    @Column(length = 50, nullable = false)
    private String accountHolder;

    @OneToOne(mappedBy = "shippingCompany")
    private Shipping shipping;
}
