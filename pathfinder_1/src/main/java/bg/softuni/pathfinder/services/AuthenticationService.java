package bg.softuni.pathfinder.services;

import bg.softuni.pathfinder.models.dto.binding.UserLoginBindingModel;
import bg.softuni.pathfinder.models.dto.binding.UserRegisterBindingModel;

public interface AuthenticationService {
    void register(UserRegisterBindingModel userRegisterBindingModel);

    boolean login(UserLoginBindingModel userLoginBindingModel);

    void logout();
}
