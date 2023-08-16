package com.epam.posts.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.mapping.List;

import java.util.Set;

@Entity
@Table(name="POST")
@Data
@NoArgsConstructor
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private String title;
    @Column
    private String content;

    @OneToMany
    @JoinColumn(name = "post_id")
    Set<Tag> tags;

    public Post(String title, String content) {
        this.title  = title;
        this.content = content;
    }

    public Post(String title, String content, Set<Tag> tags) {
        this.title  = title;
        this.content = content;
        this.tags = tags;
    }
}
