package my_project.com.my_project.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import my_project.com.my_project.model.enums.CosmeticType;

@Entity
@Table(name = "cosmetics")
@Getter
@Setter
public class Cosmetic extends BaseProduct{
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private long id;

    @Column(name = "types", nullable = false, unique = true)
    @Enumerated(value = EnumType.STRING)
    private CosmeticType type;
}
