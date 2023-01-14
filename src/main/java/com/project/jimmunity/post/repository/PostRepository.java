package com.project.jimmunity.post.repository;

import com.project.jimmunity.post.Post;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PostRepository extends JpaRepository<Post, UUID>, PostRepositoryCustom{

    @EntityGraph(attributePaths = {"commentList"})
    Optional<Post> findPostByPostId(UUID postId);

    

}

