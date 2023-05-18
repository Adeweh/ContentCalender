package com.example.contentcalender.content;

import com.example.contentcalender.enums.Status;
import com.example.contentcalender.enums.Type;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;


import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@Data
public class Content {
        @Id
        Integer id;
        @NotBlank
        String title;
        String description;
        Status status;
        Type contentType;
        LocalDateTime dateCreated;
        LocalDateTime dateUpdated;
        String url;


        public Content() {

        }


}
