package com.epam.posts.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@Embeddable
@EqualsAndHashCode
@Data
public class PostTagId implements Serializable {
    @Column(name = "post_id")
    private Long postId;
    @Column(name = "tag_id")
    private Long tagId;
}
