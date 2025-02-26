package my_project.com.my_project.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "herbs")
@Getter
@Setter
public class Herb extends BaseProduct{
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private long id;

    @Column(name = "herb_name", nullable = false, unique = true)
    private String herbName;
}
