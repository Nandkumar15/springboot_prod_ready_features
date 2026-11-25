package com.learning.prod_ready_features.config;

import com.learning.prod_ready_features.auth.AuditorAwareimpl;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration
@EnableJpaAuditing(auditorAwareRef = "getAditorAwareImpl")
public class AppConfig {

    @Bean
    ModelMapper getModelMapper(){
        return new ModelMapper();
    }

    @Bean
    AuditorAware<String> getAditorAwareImpl(){
        return new AuditorAwareimpl();
    }
}
