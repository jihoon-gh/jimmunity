package com.project.jimmunity.post.repository;

import com.project.jimmunity.post.Post;
import com.project.jimmunity.post.PostType;
import com.project.jimmunity.post.SearchOption;

import java.time.LocalDateTime;
import java.util.List;

public interface PostRepositoryCustom {

    List<Post> searchHotTopicsOfWeekendWithType(PostType postType, LocalDateTime localDateTime);

    List<Post> searchPostsWithKeyword(SearchOption option, String keyword);

}
