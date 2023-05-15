package com.example.contentcalender.repository;

import com.example.contentcalender.content.Content;
import org.springframework.data.repository.ListCrudRepository;

public interface ContentRepository extends ListCrudRepository<Content, Integer> {
}
