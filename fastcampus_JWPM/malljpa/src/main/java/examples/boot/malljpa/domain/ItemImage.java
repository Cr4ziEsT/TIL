package examples.boot.malljpa.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "item_image")
@Getter
@Setter
public class ItemImage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Long id;
    @Column(length = 255)
    private String fileName;
    @Column(length = 255)
    private String fileSize;
    @Column(length = 255)
    private String filePath;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id")
    private Item item;
}
