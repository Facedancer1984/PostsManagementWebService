package com.epam.posts.web;

import com.epam.posts.entity.Post;
import com.epam.posts.entity.TagType;
import com.epam.posts.repository.PostRepository;
import com.epam.posts.repository.TagTypeRepository;
import com.epam.posts.repository.TagTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RequestMapping("/api")
@RestController
@RequiredArgsConstructor
public class PostsController {
    private final PostRepository postRepository;
    private final TagTypeRepository tagTypeRepository;
    @Autowired
    private TagTypeRepository tagTypeRepository;

    @GetMapping("/posts")
    public ResponseEntity<Page<Post>> getAllPosts(@RequestParam(value = "tags", required = false) Set<Long> tags,
                                                  @RequestParam(defaultValue = "0") int page,
                                                  @RequestParam(defaultValue = "3") int size) {
        try {
            Pageable paging = PageRequest.of(page, size);

            Page<Post> pagePosts = tags == null
                                           ? postRepository.findAll(paging)
                                           : postRepository.findAllByTagIdIn(tags, paging);

            if (pagePosts.getTotalElements()==0) {
                return ResponseEntity.noContent().build();
            }

            return new ResponseEntity<>(pagePosts, HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @PostMapping("/posts")
    public ResponseEntity<Post> createPost(@RequestBody Post post) {
        Post newPost = postRepository.save(post);
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

    @GetMapping("/tag_types")
    public ResponseEntity<List<TagType>> getAllTagTypes() {
        List<TagType> tagTypes = tagTypeRepository.findAll();
        return new ResponseEntity<>(tagTypes, HttpStatus.OK);
    }

    @GetMapping("/tags")
    public ResponseEntity<List<TagType>> getTags() {
        return ResponseEntity.ok(tagTypeRepository.findAll());
    }
}
