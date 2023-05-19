package com.example.contentcalender;

import com.example.contentcalender.config.ContentCalenderProperties;
import com.example.contentcalender.content.Content;
import com.example.contentcalender.enums.Status;
import com.example.contentcalender.enums.Type;
import com.example.contentcalender.repository.ContentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;

@SpringBootApplication
@EnableConfigurationProperties(ContentCalenderProperties.class)
public class ContentCalenderApplication {

    public static void main(String[] args) {

        SpringApplication.run(ContentCalenderApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(ContentRepository repository){
        return args -> {

                Content content = new Content(1,"Hello Luminaries","All about graduation", Status.IDEA, Type.VIDEO, LocalDateTime.now(), null, "");

                repository.save(content);

        };

    }



}
