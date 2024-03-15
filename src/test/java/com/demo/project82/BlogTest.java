package com.demo.project82;

import com.demo.project82.blog.Blog;
import com.demo.project82.blog.BlogComment;
import com.demo.project82.blog.BlogRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BlogTest {

    @Autowired
    BlogRepository blogRepository;

    @Test
    public void test() {
        Blog blog = new Blog("First blog");
        blog.getComments().add(
                new BlogComment("My first review")
        );
        blog.getComments().add(
                new BlogComment("My second review")
        );
        blog.getComments().add(
                new BlogComment("My third review")
        );
        blogRepository.save(blog);
        blogRepository.findAll().forEach(System.out::println);
    }
}
