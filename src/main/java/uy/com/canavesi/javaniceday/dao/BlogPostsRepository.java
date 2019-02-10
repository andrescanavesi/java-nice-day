package uy.com.canavesi.javaniceday.dao;

import org.springframework.data.repository.PagingAndSortingRepository;
import uy.com.canavesi.javaniceday.domain.BlogPost;

/**
 *
 * @author Andres Canavesi
 */
public interface BlogPostsRepository extends PagingAndSortingRepository<BlogPost, Long> {

}
