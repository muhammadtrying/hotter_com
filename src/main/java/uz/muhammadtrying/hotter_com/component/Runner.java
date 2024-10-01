package uz.muhammadtrying.hotter_com.component;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import uz.muhammadtrying.hotter_com.entity.User;
import uz.muhammadtrying.hotter_com.service.UserService;

@Component
@RequiredArgsConstructor
public class Runnable implements java.lang.Runnable {
    private final PasswordEncoder passwordEncoder;
    private final UserService userService;
    @Value("${spring.jpa.hibernate.ddl-auto}")
    private String ddl;

    @Override
    public void run() {
        if (ddl.equals("create")) {
            generateData();
        }
    }

    private void generateData() {
        final User father = User.builder()
                .email("muhammadtrying@gmail.com")
                .nickname("Muhammad")
                .password(passwordEncoder.encode("root123"))
                .rating(1400)
                .photoUrl("https://images.indianexpress.com/2021/10/jessi-eisenberg-1200.jpg?w=414")
                .build();
        userService.save(father);
    }
}
