package hellojpa.entity;

import javax.persistence.*;

@Entity                     // javax.persistence.Entity 를 import 받아야 한다.
public class Member {
    @Id                     // PK
    @GeneratedValue
    private Long id;

    private int age;

    @Column(name = "USERNAME", nullable = true, length = 20)
    private String name;

//    @Column(name = "TEAM_ID")
//    private Long teamId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TEAM_ID")
    private Team team;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }
}