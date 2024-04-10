package com.JavaExampleProjects.emsbackend.Controller;

import com.JavaExampleProjects.emsbackend.Entity.User;
import com.JavaExampleProjects.emsbackend.Event.RegistrationCompleteEvent;
import com.JavaExampleProjects.emsbackend.Registration.RegistrationRequest;
import com.JavaExampleProjects.emsbackend.Service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/register")
public class RegistrationController {

    private final UserService userService;
    private final ApplicationEventPublisher publisher;



    //Rejestruje użytkownika w bazie danych
    @PostMapping
    public String registerUser(@RequestBody RegistrationRequest registrationRequest, final HttpServletRequest request){
        User user = userService.registerUser(registrationRequest); //Jeżeli user prawidłowo został zarejestrowany w bazie, to

        publisher.publishEvent(new RegistrationCompleteEvent(user, applicationUrl(request)));// klasa publisher, wykona metoda publishEvent
        return "Success! Please, check your email for to complete your registration";
    }

    public String applicationUrl(HttpServletRequest request) {
         return "http://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
    }

}
