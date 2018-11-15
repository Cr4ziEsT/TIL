package examples.boot.malljpa.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "shipping")
@Getter
@Setter
public class Shipping {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 50, nullable = false)
    private String recipient;
    @Column(length = 50, nullable = false)
    private String destination;
    @Column(length = 50, nullable = false)
    private String phoneNum;
    @Column(length = 255, nullable = false)
    private String message;
    @Column(nullable = false)
    private int money;

    @OneToOne(mappedBy = "shipping")
    private Ordering ordering;

    @OneToOne
    @JoinColumn(name = "shipping_company_id")
    private ShippingCompany shippingCompany;
}
