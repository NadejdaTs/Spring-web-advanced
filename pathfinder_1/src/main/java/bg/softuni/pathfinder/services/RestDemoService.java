package bg.softuni.pathfinder.services;

import bg.softuni.pathfinder.dto.UserLoginDTO;
import bg.softuni.pathfinder.dto.UserRegistrationDTO;
import bg.softuni.pathfinder.models.User;

import java.util.List;

public interface RestDemoService {
    List<User> getAll();

    boolean loginUser(UserLoginDTO userLoginDTO);

    boolean registerUser(UserRegistrationDTO userRegistrationDTO);
}
