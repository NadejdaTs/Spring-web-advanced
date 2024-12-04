package bg.softuni.pathfinder.models.dto.binding;

import bg.softuni.pathfinder.models.enums.Level;
import bg.softuni.pathfinder.models.enums.CategoryName;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import java.util.Set;

@Getter
@Setter
public class AddRouteBindingModel {

    @Size(min = 3, message = "Name length must be more than 3 characters")
    private String name;

    @Size(min = 5, message = "Description length must be more than 5 characters")
    private String description;
//    @File()
    private MultipartFile gpxCoordinates;
    private Level level;
    private String videoUrl;
    private Set<CategoryName> categories;
}
