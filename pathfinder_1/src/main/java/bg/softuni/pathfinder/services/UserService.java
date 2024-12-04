package bg.softuni.pathfinder.services;

import bg.softuni.pathfinder.models.User;
import bg.softuni.pathfinder.models.dto.view.UserProfileViewModel;

import java.util.Optional;

public interface UserService {
    Optional<User> getLoggedUser();

    UserProfileViewModel getUserProfile();
}
