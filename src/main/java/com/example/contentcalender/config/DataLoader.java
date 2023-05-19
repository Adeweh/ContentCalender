package com.example.contentcalender.config;

import aj.org.objectweb.asm.TypeReference;
import com.example.contentcalender.content.Content;
import com.example.contentcalender.repository.ContentRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.util.List;


@Component
@AllArgsConstructor
public class DataLoader implements CommandLineRunner {
    private final ContentRepository repository;
    private final ObjectMapper mapper;
    @Override
    public void run(String... args) throws Exception {
        try (InputStream inputStream = TypeReference.class.getResourceAsStream("/data/content.json")){
            repository.saveAll(mapper.readValue(inputStream,new TypeReference<List<Content>>(){}));
        }
    }
}
