package com.codegym.controller;

import com.codegym.model.Blog;
import com.codegym.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BlogRestController {

    @Autowired
    private BlogService blogService;

    @GetMapping(value = "/api/blog")
    public ResponseEntity<Iterable<Blog>> listAllBlog() {
        Iterable<Blog> blogs = blogService.findAll();
        return new ResponseEntity<>(blogs, HttpStatus.OK);
    }

    @PostMapping(value = "/api/blog/{id}")
    public ResponseEntity<Blog> detailBlog(@PathVariable("id") Long id) {
        Blog blogDetail = blogService.findById(id);
        if (blogDetail == null) return new ResponseEntity<Blog>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<>(blogDetail, HttpStatus.OK);
    }


}
