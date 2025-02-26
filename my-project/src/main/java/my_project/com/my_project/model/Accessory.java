package my_project.com.my_project.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "accessories")
@Getter
@Setter
public class Accessory extends BaseProduct{
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private long id;

    @Column(name = "accessory_name", nullable = false, unique = true)
    private String accessoryName;
}
