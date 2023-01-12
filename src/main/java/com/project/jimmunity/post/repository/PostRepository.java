package com.project.jimmunity.post.repository;

import com.project.jimmunity.post.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PostRepository extends JpaRepository<Post, UUID>, PostRepositoryCustom{


}

