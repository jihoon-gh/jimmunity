package com.project.jimmunity.entityTest;

import com.project.jimmunity.comment.Comment;
import com.project.jimmunity.comment.CommentLike;
import com.project.jimmunity.member.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CommentLikeTest {

    @Test
    public void commentLikeConstructTest(){
        //given
        Member member = new Member();
        Comment comment = new Comment();

        //when
        CommentLike commentLike = new CommentLike(member, comment);

        //then
        assertThat(member.getCommentLikeList().size()).isEqualTo(1);
        assertThat(comment.getCommentLikeList().size()).isEqualTo(1);
    }
}
