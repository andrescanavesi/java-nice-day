package uy.com.canavesi.javaniceday.controllers;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import uy.com.canavesi.javaniceday.dao.BlogPostsRepository;
import uy.com.canavesi.javaniceday.domain.BlogPost;

/**
 *
 * @author Andres Canavesi
 */
@Controller
public class AdminController {

    @Autowired
    private BlogPostsRepository repository;

    @RequestMapping("/admin")
    public String page(Model model) {
        List<BlogPost> posts = StreamSupport
                .stream(this.repository.findAll().spliterator(), true)
                .collect(Collectors.toList());
        model.addAttribute("posts", posts);
        return "admin";//the view name
    }

    @RequestMapping("/admin/edit/{id}")
    public String editBlogPost(Model model, @PathVariable("id") Long id) {

        Optional<BlogPost> blogPost = repository.findById(id);
        if (blogPost.isPresent()) {
            model.addAttribute("post", blogPost.get());
        } else {
            throw new RuntimeException("Post not found");
        }
        return "blog_post_edit";//the view name
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Error message")
    public void handleError() {
    }

}
