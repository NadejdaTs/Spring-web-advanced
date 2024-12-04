package bg.softuni.pathfinder.services.impl;

import bg.softuni.pathfinder.dto.UserLoginDTO;
import bg.softuni.pathfinder.dto.UserRegistrationDTO;
import bg.softuni.pathfinder.models.enums.Level;
import bg.softuni.pathfinder.models.Role;
import bg.softuni.pathfinder.models.User;
import bg.softuni.pathfinder.models.enums.UserRole;
import bg.softuni.pathfinder.repositories.RoleRepository;
import bg.softuni.pathfinder.repositories.UserRepository;
import bg.softuni.pathfinder.services.RestDemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class RestDemoServiceImpl implements RestDemoService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    @Autowired
    public RestDemoServiceImpl(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public List<User> getAll() {
        return this.userRepository.findAll();
    }

    @Override
    public boolean loginUser(UserLoginDTO userLoginDTO) {
        Optional<User> userOptional = this.userRepository.findByUsername(userLoginDTO.getUsername());

        if (userOptional.isEmpty()) {
            return false;
        }

        User user = userOptional.get();

        /*if (!this.passwordEncoder.matches(userLoginDTO.getPassword(), user.getPassword())) {
            return false;
        }*/
        Role role = this.roleRepository.findByName(UserRole.USER);
        Set<Role> roles = new HashSet<>();
        roles.add(role);

        User userResult = new User();
        new User()
                .setId(user.getId())
                .setUsername(user.getUsername())
                .setAge(user.getAge())
                .setFullName(user.getFullName())
                .setLevel(user.getLevel())
                .setRole(user.getRole())
                .setLevel(user.getLevel());

        return true;
    }

    @Override
    public boolean registerUser(UserRegistrationDTO userRegistrationDTO) {
        Role role = this.roleRepository.findByName(UserRole.USER);
        Set<Role> roles = new HashSet<>();
        roles.add(role);

        User user = new User()
                .setUsername(userRegistrationDTO.getUsername())
                .setFullName(userRegistrationDTO.getFullName())
                .setEmail(userRegistrationDTO.getEmail())
                .setAge(userRegistrationDTO.getAge())
//                .setPassword(this.passwordEncoder.encode(userRegistrationDTO.getPassword()))
                .setPassword(userRegistrationDTO.getPassword())
                .setLevel(Level.BEGINNER)
                .setRole(roles);

        this.userRepository.save(user);

        return true;
    }

}
