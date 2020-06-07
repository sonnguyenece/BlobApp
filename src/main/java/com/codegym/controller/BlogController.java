package com.codegym.controller;

import com.codegym.model.Blog;
import com.codegym.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class BlogController {

    @Autowired
    private BlogService blogService;

    @GetMapping("/homepage")
    public ModelAndView showAllBlog() {
        ModelAndView modelAndView = new ModelAndView("/blog/blogList");
        Iterable<Blog> list = blogService.findAll();
        modelAndView.addObject("list", list);
        return modelAndView;
    }

    @GetMapping("/addBlog")
    public ModelAndView addBlog() {
        ModelAndView modelAndView = new ModelAndView("/blog/add");
//        Iterable<Blog> list = blogService.findAll();
        modelAndView.addObject("blog", new Blog());
        return modelAndView;
    }

    @PostMapping("/addBlog")
   public  String addNewBlog(Blog blog){
        blogService.save(blog);
        return "redirect:/homepage";
    }

}
