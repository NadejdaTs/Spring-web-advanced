package bg.softuni.pathfinder.models;

import bg.softuni.pathfinder.models.enums.CategoryName;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "categories")
@Getter
@Setter
@NoArgsConstructor
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "TEXT", nullable = false)
//    @Lob
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private CategoryName name;
}
