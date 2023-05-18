package com.example.contentcalender.repository;

import com.example.contentcalender.content.Content;
import com.example.contentcalender.enums.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ContentRepository extends JpaRepository<Content, Integer> {

    List<Content> findAllByTitleContains(String keyword);

//    @Query("""
//                SELECT * FROM Content
//                where status = :status
//        """)
//    List<Content> listByStatus(@Param("status") Status status);
    List<Content> findContentByStatus(Status status);
}
