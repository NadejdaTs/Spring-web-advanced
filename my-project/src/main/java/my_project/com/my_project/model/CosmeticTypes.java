package my_project.com.my_project.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import my_project.com.my_project.model.enums.CosmeticType;

@Entity
@Table(name = "cosmetic_types")
@Getter
@Setter
public class CosmeticTypes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Enumerated(value = EnumType.STRING)
    private CosmeticType name;
}