package com.JavaExampleProjects.emsbackend.Event.Listener;

import com.JavaExampleProjects.emsbackend.Entity.User;
import com.JavaExampleProjects.emsbackend.Event.RegistrationCompleteEvent;
import com.JavaExampleProjects.emsbackend.Service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.util.UUID;


@Slf4j
@Component
@RequiredArgsConstructor
public class RegistrationCompleteEventListener
        implements ApplicationListener<RegistrationCompleteEvent> {

    private final UserService userService;
    @Override
    public void onApplicationEvent(RegistrationCompleteEvent event){



        // 1. Get the newly created user

        User theUser = event.getUser();

        // 2. Create a verification taken for the user

        String verificationToken = UUID.randomUUID().toString();

        // 3. Save the verification token for the user

        userService.saveUserVerificationToken(theUser, verificationToken);

        // 4. Build the verification url to be sent to the user

        String url = event.getApplicationUrl() + "/register/verifyEmail?token="+verificationToken;

        // 5. Send  the email

        log.info("Click the link to veify your registration : {}", url);
    }


}
