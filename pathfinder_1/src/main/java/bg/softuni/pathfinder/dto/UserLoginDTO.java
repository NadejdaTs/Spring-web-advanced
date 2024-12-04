package bg.softuni.pathfinder.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserLoginDTO {
    private String username;
    private String password;

    public UserLoginDTO setUsername(String username) {
        this.username = username;
        return this;
    }

    public UserLoginDTO setPassword(String password) {
        this.password = password;
        return this;
    }
}
