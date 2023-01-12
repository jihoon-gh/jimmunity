package com.project.jimmunity.post.repository;

import com.project.jimmunity.post.Post;
import com.project.jimmunity.post.PostType;
import com.project.jimmunity.post.QPost;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

import static com.project.jimmunity.post.QPost.*;

@RequiredArgsConstructor
public class PostRepositoryImpl implements PostRepositoryCustom{

    private final JPAQueryFactory queryFactory;

    @Override
    public List<Post> searchHotTopicsOfWeekendWithType(PostType postType, LocalDateTime localDateTime) {
        return queryFactory
                .select(post)
                .from(post)
                .where(isPostTypeEq(postType), isInSame7days(localDateTime))
                .fetch();
    }

    private BooleanExpression isPostTypeEq(PostType postType){
        return postType == null ? null : post.postType.stringValue().eq(postType.name());
    }

    private BooleanExpression isInSame7days(LocalDateTime localDateTime){
        return localDateTime == null ? null : post.createdAt.goe(localDateTime.minusDays(7));
    }
}
