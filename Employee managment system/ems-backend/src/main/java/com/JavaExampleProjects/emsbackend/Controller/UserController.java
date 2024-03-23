package com.JavaExampleProjects.emsbackend.Controller;
import com.JavaExampleProjects.emsbackend.Entity.User;
import com.JavaExampleProjects.emsbackend.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    public List<User> getUsers(){
        return userService.getUsers();
    }
}
