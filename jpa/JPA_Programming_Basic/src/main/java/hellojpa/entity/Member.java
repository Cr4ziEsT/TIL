package hellojpa.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity                     // javax.persistence.Entity 를 import 받아야 한다.
public class Member {
    @Id                     // PK
    private Long id;
    private String name;

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
}
