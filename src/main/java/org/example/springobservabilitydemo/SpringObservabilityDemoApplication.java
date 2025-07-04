package org.example.springobservabilitydemo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringObservabilityDemoApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(SpringObservabilityDemoApplication.class, args);
    }

    @Override
    public void run(String... args) {
    }
}
