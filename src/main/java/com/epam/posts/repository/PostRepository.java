package com.epam.posts.repository;

import com.epam.posts.entity.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface PostRepository extends PagingAndSortingRepository<Post, Long> {
    Post findById(long id);
    Post save(Post post);

    Page<Post> findAll(Pageable pageable);

    @Query("SELECT p FROM Post p WHERE tags in :ids")
    Page<Post> findAllByTagIds(@Param("ids") Set<Long> ids, Pageable pageable);

    void deleteById(long id);

}
