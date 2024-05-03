package com.example.SpringPratciceProject.controller;

import com.example.SpringPratciceProject.entity.Blog;
import com.example.SpringPratciceProject.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BlogController {

    @Autowired
    BlogService blogService;

    @PostMapping("/add-blog")
    public Blog saveBlog(@RequestBody Blog blog){
        return blogService.saveBlog(blog);
    }

    @GetMapping("/getblogs")
    public List<Blog> getAllBlogs(){
        return blogService.getAllBlogs();
    }

    @GetMapping("/getBlog/{id}")
    public Blog getOwnerById(@PathVariable("id") Long bId){
        return blogService.getBlogById(bId);
    }

    @GetMapping("/getBlogByName/{name}")
    public Blog getBlogByName(@PathVariable("name") String bName){
        return blogService.getBlogByName(bName);
    }

    @PostMapping("/updateBlogData/{id}")
    public Blog updateBlog(@RequestBody Blog blog, @PathVariable("id") Long bId){
        return blogService.updateBlog(blog, bId);
    }

    @DeleteMapping("/deleteBlog/{id}")
    public String deleteBlog(@PathVariable("id") Long bId){
        blogService.deleteBlog(bId);
        return "Deleted Successfully";
    }
}
