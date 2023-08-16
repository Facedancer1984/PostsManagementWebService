package com.epam.posts.web;

import com.epam.posts.entity.Post;
import com.epam.posts.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@RequestMapping("/api")
@RestController
public class PostsController {

    @Autowired
    private PostRepository postRepository;

    @GetMapping("/posts")
    public ResponseEntity<List<Post>> getAllPosts(@RequestParam(value = "tags", required = false) Set<Long> tags,
                                                  @RequestParam(defaultValue = "0") int page,
                                                  @RequestParam(defaultValue = "3") int size) {
        try {
            List<Post> posts = new ArrayList<Post>();
            Pageable paging = PageRequest.of(page, size);

            Page<Post> pagePosts;
            if (tags == null)
                pagePosts = postRepository.findAll(paging);
            else
                pagePosts = postRepository.findAllByTagIds(tags, paging);

            posts = pagePosts.getContent();

            if (posts.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(posts, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/posts")
    public ResponseEntity<Post> createPost(@RequestBody Post post) {
        Post newPost = postRepository.save(new Post(post.getTitle(), post.getContent(), post.getTags()));
        return new ResponseEntity<>(newPost, HttpStatus.CREATED);
    }

    @PutMapping("/posts/{id}")
    public ResponseEntity<Post> updatePostTags(@PathVariable("id") long id, @RequestBody Set<Long> tags) {
        Post post = postRepository.findById(id);

        if (post == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }



        return new ResponseEntity<>(post, HttpStatus.OK);
    }

    @DeleteMapping("/posts/{id}")
    public ResponseEntity<HttpStatus> deletePost(@PathVariable("id") long id) {
        postRepository.deleteById(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
