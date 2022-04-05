package com.example.demo.Content;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class ContentConfig {

    @Bean
    CommandLineRunner commandLineRunner( ContentRepository repository){
        return args -> {
            Content abyss =
            new Content(
                    "The Abyss",
                    "The Beginning",
                    1
            );

            Content resurrection =
            new Content(
                    "Resurrection",
                    "The Beginning",
                    1
            );

            Content ids =
            new Content(
                    "ID's Only",
                    "The Beginning",
                    1
            );

            repository.saveAll(List.of(abyss, resurrection, ids));

        };
    }
}
