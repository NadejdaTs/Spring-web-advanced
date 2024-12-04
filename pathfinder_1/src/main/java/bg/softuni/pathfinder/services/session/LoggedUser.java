package bg.softuni.pathfinder.services.session;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
public class LoggedUser {
    private String username;
    private String email;
    private String fullName;
    private boolean isLogged;

    public void reset() {
        setUsername(null);
        setEmail(null);
        setFullName(null);
        setLogged(false);
    }
}
