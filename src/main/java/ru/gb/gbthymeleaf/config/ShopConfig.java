package ru.gb.gbthymeleaf.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.Optional;

@Configuration
@EnableJpaAuditing(auditorAwareRef = "auditAwareBean")
public class ShopConfig {

    @Bean
    public AuditorAware<String> auditAwareBean() {
        return () -> Optional.of("User");
    }
}
