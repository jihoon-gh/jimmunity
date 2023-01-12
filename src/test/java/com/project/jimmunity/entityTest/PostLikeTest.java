package com.project.jimmunity.entityTest;

import com.project.jimmunity.member.Member;
import com.project.jimmunity.post.Post;
import com.project.jimmunity.post.PostLike;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PostLikeTest {

    @Test
    public void postLikeConstructTest(){
        //given
        Member member = new Member();
        Post post = new Post();

        //when
        PostLike postLike = new PostLike(member, post);

        //then
        assertThat(member.getPostLikeList()).isEqualTo(1);
        assertThat(post.getPostLikeList().size()).isEqualTo(1);
    }

}
