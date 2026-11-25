package com.learning.prod_ready_features.auth;

import org.springframework.data.domain.AuditorAware;

import java.util.Optional;

public class AuditorAwareimpl implements AuditorAware<String> {
    @Override
    public Optional<String> getCurrentAuditor() {
       //get security context
        //get authentication
        //get the principle
        //get the username
        return Optional.of("Nandkumar Singh");
    }
}
