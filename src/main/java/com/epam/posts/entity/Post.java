package com.epam.posts.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Table(name="POST")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private String title;
    @Column
    private String content;

    @OneToMany(fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
    Set<TagType> tags;

    public Post(String title, String content) {
        this.title  = title;
        this.content = content;
    }
}
