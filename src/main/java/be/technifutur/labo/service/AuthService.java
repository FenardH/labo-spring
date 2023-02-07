package be.technifutur.labo.service;


import be.technifutur.labo.jwt.JWTHolderDTO;
import be.technifutur.labo.model.form.LoginForm;
import be.technifutur.labo.model.form.RegistrationForm;

public interface AuthService {
    public void register(RegistrationForm form);
    public JWTHolderDTO login(LoginForm form);
}
