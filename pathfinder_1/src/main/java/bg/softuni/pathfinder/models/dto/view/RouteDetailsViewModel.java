package bg.softuni.pathfinder.models.dto.view;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
public class RouteDetailsViewModel {
    private Long id;
    private String name;
    private String level;
    private String description;
    private String videoUrl;
    private String authorName;
//    TODO pass coordinates
}
