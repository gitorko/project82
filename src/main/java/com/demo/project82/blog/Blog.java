package com.demo.project82.blog;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

/**
 * https://vladmihalcea.com/the-best-way-to-map-a-onetomany-association-with-jpa-and-hibernate/
 */

@Entity
@Table(name = "blog")
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Data
@ToString(exclude = "comments")
public class Blog {

    @Id
    @GeneratedValue
    private Long id;

    @NonNull
    private String title;

    @OneToMany(
            mappedBy = "blog",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<BlogComment> comments = new ArrayList<>();

    public void addComment(BlogComment comment) {
        comments.add(comment);
        comment.setBlog(this);
    }

    public void removeComment(BlogComment comment) {
        comments.remove(comment);
        comment.setBlog(null);
    }

}


