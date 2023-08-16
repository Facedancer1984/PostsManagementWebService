package com.epam.posts.entity;

import jakarta.persistence.*;
import org.hibernate.mapping.List;

import java.util.Set;

@Entity
@Table(name="POST")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private String title;
    @Column
    private String content;

    @OneToMany
    @JoinColumn(name = "tag_id")
    Set<Tag> tags;

    public Post() {}

    public Post(String title, String content) {
        this.title  = title;
        this.content = content;
    }

    public Post(String title, String content, Set<Tag> tags) {
        this.title  = title;
        this.content = content;
        this.tags = tags;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return this.title;
    }

    public String getContent() {
        return this.content;
    }

    public Set<Tag> getTags() {
        return this.tags;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setTags(Set<Tag> tags) {
        this.tags = tags;
    }
}
