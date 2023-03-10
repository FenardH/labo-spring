package be.technifutur.labo.model.form;

import be.technifutur.labo.model.entity.User;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.Set;

@Data
public class RegistrationForm {
    @NotNull
    private String username;
    @NotNull
    @Size(min = 4)
    private String password;
    @NotNull
    @Size(min = 4)
    private String confirmedPassword;

    public User toEntity() {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setRoles(Set.of("USER"));

        return user;
    }

}
