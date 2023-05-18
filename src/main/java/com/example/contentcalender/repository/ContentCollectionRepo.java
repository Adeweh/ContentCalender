package com.example.contentcalender.repository;

import com.example.contentcalender.content.Content;
import com.example.contentcalender.enums.Status;
import com.example.contentcalender.enums.Type;
import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
@AllArgsConstructor
public class ContentCollectionRepo {

    private final List<Content> contentList = new ArrayList<>();

    public List<Content> findAll (){
        return contentList;
    }

    public Optional<Content> findById(Integer id){
        return contentList.stream().filter(c -> c.getId().equals(id)).findFirst();
    }

    @PostConstruct
    private void init(){
        Content content = new Content(1,"First Post","This is a contentList", Status.IDEA, Type.ARTICLE, LocalDateTime.now(), null, "");
        contentList.add(content);
    }
    public void save(Content content){
        contentList.removeIf(c -> c.getId().equals(content.getId()));
        contentList.add(content);
    }


    public boolean existsById(Integer id) {
        return contentList.stream().filter(c-> c.getId().equals(id)).count() == 1;
    }

    public void delete(Integer id) {
        contentList.removeIf(c -> c.getId().equals(id));
    }
}
