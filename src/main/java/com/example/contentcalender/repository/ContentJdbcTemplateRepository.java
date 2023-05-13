package com.example.contentcalender.repository;

import com.example.contentcalender.content.Content;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@AllArgsConstructor
@Repository
public class ContentJdbcTemplateRepository {
    private final JdbcTemplate jdbcTemplate;

    private static Content mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Content(rs.getInt(columnLabel: "id"),
        rs.getString(columnLabel: "title"),
        rs.getString(columnLabel: "description"),
        rs.getString(columnLabel: "status"),
        rs.getString(columnLabel: "content_type"),
        rs.getTimestamp(columnLabel: "date_created"),
        rs.getTimestamp(columnLabel: "date_updated"),
        rs.getString(columnLabel: "url")
        );
    }

    public List<Content> getAllContent(){
        String sql = "SELECT * FROM Content";
        List<Content> contents = jdbcTemplate.query(sql, ContentJdbcTemplateRepository::mapRow);
        return contents;
    }

    public void createContent(String title, String description, String status, String contentType, String URL) {
        String sql = "INSERT INTO Content (title, description, status, content_type, date_created, URL) VALUES (?, ?, ?, ?, NOW(), ?)";
        jdbcTemplate.update(sql, title, description, status, contentType, URL);
    }
    public void updateContent(int id, String title, String description, String status, String contentType, String URL) {
        String sql = "UPDATE Content SET title=?, description=?, status=?, content_type=?, date_updated=NOW(), url=? WHERE id=?";
        jdbcTemplate.update(sql, title, description, status, contentType, URL, id);
    }
    public void deleteContent(int id){
        String sql = "DELETE FROM Content WHERE id=?";
        jdbcTemplate.update(sql, id);
    }
    public Content getContent(int id){
        String sql = "SELECT * FROM Content WHERE id=?";
        Content content = jdbcTemplate.queryForObject(sql, new Object[]{id}, ContentJdbcTemplateRepository::mapRow );
        return content;

    }

}
