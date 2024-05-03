package com.example.SpringPratciceProject.service;

import com.example.SpringPratciceProject.entity.Blog;
import com.example.SpringPratciceProject.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class BlogService {

    @Autowired
    BlogRepository blogRepository;

    public Blog saveBlog(Blog blog){
        return blogRepository.save(blog);
    }

    public List<Blog> getAllBlogs(){
        return blogRepository.findAll();
    }

    public Blog getBlogById(Long id){
        Optional<Blog> bId = blogRepository.findById(id);
        if(!bId.isPresent()){
            throw new RuntimeException("Owner not found");
        }
        return bId.get();
    }

    public Blog getBlogByName(String name){
        return blogRepository.findByBlogName(name);
    }

    public Blog updateBlog(Blog blog, Long id){
        Optional<Blog> bId = blogRepository.findById(id);
        if(!bId.isPresent()){
            throw new RuntimeException("Owner not found");
        }
        Blog existingRecord =bId.get();
        if(!existingRecord.getBlogName().equals(blog.getBlogName())){
            existingRecord.setBlogName(blog.getBlogName());
        }
        return blogRepository.save(existingRecord);
    }

    public void deleteBlog(Long id){
        blogRepository.deleteById(id);
    }

}
