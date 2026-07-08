package com.healthcare.api.config;

import com.healthcare.api.entity.User;
import com.healthcare.api.enums.Role;
import com.healthcare.api.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class AdminBootstrapConfig {

    @Bean
    CommandLineRunner initAdmin (
            UserRepository repository,
            PasswordEncoder encoder
    ) {
        return args -> {
            if (repository.findByEmail("admin@admin.com").isEmpty()) {
                User admin = new User();
                admin.setName("Administrator");
                admin.setEmail("admin@admin.com");
                admin.setPassword(
                        encoder.encode("admin123")
                );
                admin.setRole(Role.ADMIN);
                admin.setActive(true);

                repository.save(admin);
            }
        };
    }
}
