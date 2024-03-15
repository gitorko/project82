package com.demo.project82.blog;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name = "blog_comment")
@AllArgsConstructor
@NoArgsConstructor
@Data
@RequiredArgsConstructor
public class BlogComment {

    @Id
    @GeneratedValue
    private Long id;

    @NonNull
    private String review;

    @ManyToOne(fetch = FetchType.LAZY)
    private Blog blog;

}
