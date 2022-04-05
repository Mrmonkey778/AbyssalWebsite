package com.example.demo.Content;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ContentRepository extends JpaRepository <Content, Long> {

    @Query("SELECT c FROM Content c WHERE c.name = ?1")
    Optional<Content> findContentByName(String name);
}
