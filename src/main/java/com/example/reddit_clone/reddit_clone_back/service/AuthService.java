package com.example.reddit_clone.reddit_clone_back.service;

import com.example.reddit_clone.reddit_clone_back.dto.RegisterRequest;
import com.example.reddit_clone.reddit_clone_back.exceptions.SpringRedditException;
import com.example.reddit_clone.reddit_clone_back.model.NotificationEmail;
import com.example.reddit_clone.reddit_clone_back.model.User;
import com.example.reddit_clone.reddit_clone_back.model.VerificationToken;
import com.example.reddit_clone.reddit_clone_back.repository.UserRepository;
import com.example.reddit_clone.reddit_clone_back.repository.VerificationTokenRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.Instant;
import java.util.UUID;

@Service
@AllArgsConstructor
public class AuthService {

    final private PasswordEncoder passwordEncoder;
    final private UserRepository userRepository;
    final private VerificationTokenRepository verificationTokenRepository;
    final private MailService mailService;

    @Transactional
    public void signup(RegisterRequest registerRequest) {
        User user = new User();

        user.setUsername(registerRequest.getUsername());
        user.setEmail(registerRequest.getEmail());
        user.setPassword(passwordEncoder.encode(registerRequest.getPassword()));
        user.setCreated(Instant.now());
        user.setEnabled(false);

        userRepository.save(user);
        String token = generateVerificationToken(user);

        try {
            mailService.sendMail(new NotificationEmail("Please Activate your Account"
                    ,user.getEmail()
                    ,"Thank Your for signing up to Spring Reddit" +
                    "please click on the below url to activate your account :" +
                    "http://localhost:8080/api/auth/accountVerification/" + token));
        } catch (SpringRedditException e) {
            e.printStackTrace();
        }
    }

    private String generateVerificationToken(User user) {
        String token = UUID.randomUUID().toString();

        VerificationToken verificationToken = new VerificationToken();
        verificationToken.setToken(token);
        verificationToken.setUser(user);

        verificationTokenRepository.save(verificationToken);
        return token;
    }
}
