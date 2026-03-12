package com.example.fooapp;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j // Lombok generuje obiekt log automatycznie - nie piszemy Logger log = ...
public class FooComponent {

    private final String appName;

    public FooComponent(String appName) {
        this.appName = appName;
    }

    @jakarta.annotation.PostConstruct
    public void init() {
        log.info("App started: " + appName);
    }
}
