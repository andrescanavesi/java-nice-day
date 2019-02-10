package uy.com.canavesi.javaniceday.domain;

import java.io.Serializable;
import java.time.OffsetDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.NoArgsConstructor;
import lombok.Data;

/**
 *
 * @author andrescanavesi
 */
@Entity
@Table(name = "blog_posts")
@NoArgsConstructor
@Data
public class BlogPost implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String content;
    @Column(name = "created_date")
    private OffsetDateTime createdDate;

}
