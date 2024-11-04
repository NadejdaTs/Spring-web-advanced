package bg.softuni.books_server.model.dto;

import lombok.Getter;
import lombok.Setter;

public class AuthorDTO {
    private String name;

    public String getName() {
        return name;
    }

    public AuthorDTO setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public String toString() {
        return "AuthorDTO{" +
                "name='" + name + '\'' +
                '}';
    }
}
