package com.demo.project82;

import com.demo.project82.posts.Post;
import com.demo.project82.posts.PostRepository;
import com.demo.project82.posts.Tag;
import com.demo.project82.posts.TagRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PostTest {
    @Autowired
    private TagRepository tagRepository;

    @Autowired
    private PostRepository postRepository;

    @Test
    public void test() {
        Post post = new Post("Hibernate Many to Many Example with Spring Boot",
            "Learn how to map a many to many relationship using hibernate",
            "Entire Post content with Sample code");

        // Create two tags
        Tag tag1 = new Tag("Spring Boot");
        Tag tag2 = new Tag("Hibernate");


        // Add tag references in the post
        post.getTags().add(tag1);
        post.getTags().add(tag2);

        // Add post reference in the tags
        tag1.getPosts().add(post);
        tag2.getPosts().add(post);

        postRepository.save(post);
        postRepository.findAll().forEach(System.out::println);

    }
}
