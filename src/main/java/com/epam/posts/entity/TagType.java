package com.epam.posts.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="TAG_TYPE")
@Data
@NoArgsConstructor
public class TagType {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name="tag_name")
    private String tagName;

}
