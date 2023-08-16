package com.epam.posts.entity;

import jakarta.persistence.*;

@Entity
@Table(name="POST_TAG")
public class Tag {

    @EmbeddedId
    private PostTagId id;
//    @Column(name="post_id")
//    private Long postId;
//
//    @Column(name="tag_id")
//    private Long tagId;

    public Tag() {}
}
