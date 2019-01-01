package hellojpa.entity;

import javax.persistence.*;

@Entity                     // javax.persistence.Entity 를 import 받아야 한다.
public class Member {
    @Id                     // PK
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private int age;

    @Column(name = "USERNAME", nullable = true, length = 20)
    private String name;

    //    @Enumerated(EnumType.ORDINAL)       // 현업에서는 무조건 String 으로 사용해야 된다!! DB가 꼬일 수 있음
    @Enumerated(EnumType.STRING)
    private MemberType memberType;

    // getter & setter
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public MemberType getMemberType() {
        return memberType;
    }

    public void setMemberType(MemberType memberType) {
        this.memberType = memberType;
    }
}
