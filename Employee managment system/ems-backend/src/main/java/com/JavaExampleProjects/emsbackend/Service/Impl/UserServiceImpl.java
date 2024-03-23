package com.JavaExampleProjects.emsbackend.Service.Impl;

import com.JavaExampleProjects.emsbackend.Entity.User;
import com.JavaExampleProjects.emsbackend.Exception.UserAlreadyExistsException;
import com.JavaExampleProjects.emsbackend.Registration.RegistrationRequest;
import com.JavaExampleProjects.emsbackend.Repository.UserRepository;
import com.JavaExampleProjects.emsbackend.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public User registerUser(RegistrationRequest request) {

        Optional<User> user = this.findByEmail(request.email());
        if(user.isPresent()){
            throw new UserAlreadyExistsException(
                    "User with email " + request.email() + "already exists");
        }

        var newUser = new User();
        newUser.setFirstName(request.firstName());
        newUser.setLastName(request.lastName());
        newUser.setEmail(request.email());
        newUser.setPassword(passwordEncoder.encode(request.password()));
        newUser.setRole(request.role());

        return userRepository.save(newUser);
    }

    @Override
    public Optional<User> findByEmail(String email) {

        return userRepository.findByEmail(email);
    }
}
