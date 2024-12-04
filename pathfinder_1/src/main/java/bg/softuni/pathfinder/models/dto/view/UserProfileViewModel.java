package bg.softuni.pathfinder.models.dto.view;

import bg.softuni.pathfinder.models.enums.Level;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
public class UserProfileViewModel {
    private String fullName;
    private String username;
    private int age;
    private Level level;
}
