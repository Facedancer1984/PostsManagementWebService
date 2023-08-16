package com.epam.posts.repository;

import com.epam.posts.entity.TagType;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TagTypeRepository extends CrudRepository<TagType, Long> {
    List<TagType> findAll();
}
