package com.example.SpringPratciceProject.repository;

import com.example.SpringPratciceProject.entity.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogRepository extends JpaRepository<Blog,Long> {
    public Blog findByBlogName(String name);
}
