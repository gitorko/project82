package com.demo.project82.blog;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

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
