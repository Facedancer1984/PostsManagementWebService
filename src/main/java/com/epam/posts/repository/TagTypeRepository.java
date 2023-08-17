package com.epam.posts.repository;

import com.epam.posts.entity.TagType;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Set;

public interface TagTypeRepository extends CrudRepository<TagType,Integer> {
    @Override
    List<TagType> findAll();

    Set<TagType> findAllByIdIn(Set<Long> ids);
}
