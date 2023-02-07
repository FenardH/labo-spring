package be.technifutur.labo.service.impl;

import be.technifutur.labo.exceptions.FormValidationException;
import be.technifutur.labo.jwt.JWTHolderDTO;
import be.technifutur.labo.jwt.JwtProvider;
import be.technifutur.labo.model.entity.User;
import be.technifutur.labo.model.form.LoginForm;
import be.technifutur.labo.model.form.RegistrationForm;
import be.technifutur.labo.repository.UserRepository;
import be.technifutur.labo.service.AuthService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder encoder;
    private final AuthenticationManager autManager;
    private final JwtProvider jwtProvider;

    public AuthServiceImpl(UserRepository userRepository, PasswordEncoder encoder, AuthenticationManager autManager, JwtProvider jwtProvider) {
        this.userRepository = userRepository;
        this.encoder = encoder;
        this.autManager = autManager;
        this.jwtProvider = jwtProvider;
    }

    @Override
    public void register(RegistrationForm form) {
        if (!form.getPassword().equals(form.getConfirmedPassword())) {
            throw new FormValidationException("password doesn't match confirmed password");
        }

        if (userRepository.existsByUsername(form.getUsername())) {
            throw new FormValidationException("user doesn't exist");
        }

        User user = form.toEntity();
        user.setPassword(encoder.encode(user.getPassword()));

        userRepository.save(user);
    }

    @Override
    public JWTHolderDTO login(LoginForm form) {
        Authentication auth = new UsernamePasswordAuthenticationToken(
                form.getUsername(),
                form.getPassword());

        autManager.authenticate(auth);
        String token = jwtProvider.createToken(auth);

        return new JWTHolderDTO(token);
    }
}
