package com.epam.posts;

import com.epam.posts.entity.TagType;
import com.epam.posts.repository.TagTypeRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
@RequiredArgsConstructor
public class PostsApplication {
    private final TagTypeRepository tagTypeRepository;

    public static void main(String[] args) {
        SpringApplication.run(PostsApplication.class, args);
    }

    @PostConstruct
    void create() {
        List<TagType> tagTypes = List.of(
                new TagType("sport"),
                new TagType("other"));

        tagTypeRepository.saveAll(tagTypes);
    }

}
