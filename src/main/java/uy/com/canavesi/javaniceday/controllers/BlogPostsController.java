package uy.com.canavesi.javaniceday.controllers;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import uy.com.canavesi.javaniceday.dao.BlogPostsRepository;
import uy.com.canavesi.javaniceday.domain.BlogPost;

/**
 *
 * @author Andres Canavesi
 */
@Controller
public class BlogPostsController {

    @Autowired
    private Environment environment;

    @Autowired
    private BlogPostsRepository repository;

    @RequestMapping("/")
    public String page(Model model) {
        List<BlogPost> posts = StreamSupport
                .stream(this.repository.findAll().spliterator(), true)
                .collect(Collectors.toList());
        model.addAttribute("posts", posts);
        return "blog_posts";//the view name
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Error message")
    public void handleError() {
    }

}
