package uy.com.canavesi.javaniceday.controllers;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import uy.com.canavesi.javaniceday.dao.BlogPostsRepository;
import uy.com.canavesi.javaniceday.domain.BlogPost;

/**
 *
 * @author Andres Canavesi
 */
@Controller
public class BlogPostDetailController {

    @Autowired
    private Environment environment;

    @Autowired
    private BlogPostsRepository repository;

    @RequestMapping("/{id}/{title}")
    public String page(Model model, @PathVariable("id") Long id) {

        Optional<BlogPost> blogPost = repository.findById(id);
        if (blogPost.isPresent()) {
            model.addAttribute("post", blogPost.get());
        } else {
            throw new RuntimeException("Post not found");
        }
        return "blog_post_detail";//the view name
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Error message")
    public void handleError() {
    }

}
