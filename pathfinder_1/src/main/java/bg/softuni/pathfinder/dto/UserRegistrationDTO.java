package bg.softuni.pathfinder.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserRegistrationDTO {
    private String username;
    private String fullName;
    private String email;
    private Integer age;
    private String password;
    private String confirmPassword;

    public UserRegistrationDTO setUsername(String username) {
        this.username = username;
        return this;
    }

    public UserRegistrationDTO setFullName(String fullName) {
        this.fullName = fullName;
        return this;
    }

    public UserRegistrationDTO setEmail(String email) {
        this.email = email;
        return this;
    }

    public UserRegistrationDTO setAge(Integer age) {
        this.age = age;
        return this;
    }

    public UserRegistrationDTO setPassword(String password) {
        this.password = password;
        return this;
    }

    public UserRegistrationDTO setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
        return this;
    }
}
