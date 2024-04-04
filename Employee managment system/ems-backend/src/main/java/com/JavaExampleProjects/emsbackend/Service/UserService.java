package com.JavaExampleProjects.emsbackend.Service;

import com.JavaExampleProjects.emsbackend.Entity.User;
import com.JavaExampleProjects.emsbackend.Registration.RegistrationRequest;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> getUsers();
    User registerUser(RegistrationRequest request);
    Optional<User> findByEmail(String email);

    void saveUserVerificationToken(User theUser, String verificationToken);
}
