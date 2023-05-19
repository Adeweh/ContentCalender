package com.example.contentcalender.controller;

import com.example.contentcalender.config.ContentCalenderProperties;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class HomeController {
    private final ContentCalenderProperties contentCalenderProperties;
    @GetMapping("/")
    public ContentCalenderProperties home(){
        return contentCalenderProperties;
    }
}
