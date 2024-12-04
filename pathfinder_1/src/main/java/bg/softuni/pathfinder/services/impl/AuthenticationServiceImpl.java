package bg.softuni.pathfinder.services.impl;

import bg.softuni.pathfinder.models.User;
import bg.softuni.pathfinder.models.dto.binding.UserLoginBindingModel;
import bg.softuni.pathfinder.models.dto.binding.UserRegisterBindingModel;
import bg.softuni.pathfinder.models.enums.Level;
import bg.softuni.pathfinder.repositories.UserRepository;
import bg.softuni.pathfinder.services.AuthenticationService;
import bg.softuni.pathfinder.services.session.LoggedUser;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    private final UserRepository userRepository;
    private final ModelMapper mapper;
    private final PasswordEncoder passwordEncoder;
    private LoggedUser loggedUser;

    public AuthenticationServiceImpl(UserRepository userRepository, ModelMapper mapper, PasswordEncoder passwordEncoder, LoggedUser loggedUser){
        this.userRepository = userRepository;
        this.mapper = mapper;
        this.passwordEncoder = passwordEncoder;
        this.loggedUser = loggedUser;
    }
    @Override
    public void register(UserRegisterBindingModel userRegisterBindingModel) {
        User user = mapper.map(userRegisterBindingModel, User.class);
        user.setLevel(Level.BEGINNER);
        user.setPassword(passwordEncoder.encode(userRegisterBindingModel.getPassword()));
        userRepository.save(user);
    }

    @Override
    public boolean login(UserLoginBindingModel userLoginBindingModel) {
        String username = userLoginBindingModel.getUsername();
        Optional<User> user = this.userRepository.findByUsername(username);
        if(user.get() == null){
            throw new IllegalArgumentException("User with username: " + username + " is not existing!");
        }

        String pass = user.get().getPassword();
        boolean passwordMatch = passwordEncoder.matches(userLoginBindingModel.getPassword(), pass);
        if(!passwordMatch){
            throw new IllegalArgumentException("User entered incorrect password!");
        }
        this.loggedUser.setUsername(user.get().getUsername());
        this.loggedUser.setEmail(user.get().getEmail());
        this.loggedUser.setFullName(user.get().getFullName());
        this.loggedUser.setLogged(true);
        return passwordMatch;
    }

    @Override
    public void logout() {
        loggedUser.reset();
    }
}
