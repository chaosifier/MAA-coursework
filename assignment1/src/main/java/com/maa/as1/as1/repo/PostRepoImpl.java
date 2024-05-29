package com.maa.as1.as1.repo;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.maa.as1.as1.entity.Post;
import com.maa.as1.as1.entity.dto.PostCreateDto;

import java.util.ArrayList;

@Repository
public class PostRepoImpl implements PostRepo {
    private ArrayList<Post> data = new ArrayList<Post>(List.of(
            new Post(1L, "post 1", "post 1 content", "author-1"),
            new Post(2L, "post 2", "post 2 content", "author-2"),
            new Post(3L, "post 3", "post 3 content", "author-3"),
            new Post(4L, "post 4", "post 4 content", "author-4"),
            new Post(5L, "post 5", "post 5 content", "author-5"),
            new Post(6L, "post 6", "post 6 content", "author-6"),
            new Post(7L, "post 7", "post 7 content", "author-7"),
            new Post(8L, "post 8", "post 8 content", "author-8")));

    public PostRepoImpl() {
    }

    public List<Post> findAll() {
        return this.data;
    }

    public Post getById(Long postId) {
        return this.data
                .stream()
                .filter(p -> p.getId() == postId)
                .findFirst()
                .get();
    }

    public Long savePost(PostCreateDto post) {
        var newId = this.data.size() + 1L;
        var author = "test author";
        var newPost = new Post(newId, post.getTitle(), post.getContent(), author);
        this.data
                .add(newPost);

        return newId;
    }
}
