package org.csystem.app.configuration;

import org.csystem.app.data.NumberType;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class NumberInfoConfig {
    @Bean
    public NumberType [] getNumberTypeValues() {
        return NumberType.values();
    }
}
