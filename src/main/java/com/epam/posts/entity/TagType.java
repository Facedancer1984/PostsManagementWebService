package com.epam.posts.entity;

import jakarta.persistence.*;

@Entity
@Table(name="TAG_TYPE")
public class TagType {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name="tag_name")
    private String tagName;

    public TagType() {}
}
