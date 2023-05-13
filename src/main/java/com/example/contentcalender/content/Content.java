package com.example.contentcalender.content;

import com.example.contentcalender.enums.Status;
import com.example.contentcalender.enums.Type;
import jakarta.validation.constraints.NotBlank;
import java.time.LocalDateTime;

public record Content(
        Integer id,
        @NotBlank
        String title,
        String description,
        Status status,
        Type contentType,
        LocalDateTime dateCreated,
        LocalDateTime dateUpdated,
        String url

        ) {

}
