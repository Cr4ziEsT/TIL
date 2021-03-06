package examples.boot.malljpa.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "member")
@Getter
@Setter
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 50, nullable = false, unique = true)
    private String email;
    @Column(length = 50, nullable = false)
    private String name;
    @Column(length = 50, nullable = false, unique = true)
    private String nickname;
    @Column(length = 255, nullable = false)
    private String password;
    @Column(length = 15, nullable = false)
    private String phoneNum;
    @Column(length = 50, nullable = false)
    private String homeAddress;
    @Column(length = 50, nullable = false)
    private String zipCode;
    private Double height;
    private Double weight;
    private String gender;
    @Column(length = 50, nullable = false)
    private String birthDay;
    private int point;

    @OneToMany(mappedBy = "member")
    private Set<MemberCoupon> memberCoupons;

    @OneToMany(mappedBy = "member")
    private Set<CartItem> cartItems;

    @OneToMany(mappedBy = "member")
    private Set<Ordering> orderings;

    @ManyToMany
    @JoinTable(name = "member_role",
            joinColumns = @JoinColumn(name = "member_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
    private Set<Role> roles;

    @ManyToMany
    @JoinTable(name = "wish_item",
            joinColumns = @JoinColumn(name = "member_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "item_id", referencedColumnName = "id"))
    private Set<Item> items;
}
