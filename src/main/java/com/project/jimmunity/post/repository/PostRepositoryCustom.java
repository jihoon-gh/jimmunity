package com.project.jimmunity.post.repository;

import com.project.jimmunity.post.Post;
import com.project.jimmunity.post.PostType;

import java.time.LocalDateTime;
import java.util.List;

public interface PostRepositoryCustom {

    List<Post> searchHotTopicsOfWeekendWithType(PostType postType, LocalDateTime localDateTime);

}
