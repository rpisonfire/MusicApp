package com.example.fooapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FooConfig
{
    @Bean
    public String appName()
    {
        return "FooApp v1.0";
    }
}
