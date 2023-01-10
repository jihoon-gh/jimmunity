package com.project.jimmunity.entityTest;

import com.project.jimmunity.comment.Comment;
import com.project.jimmunity.member.Member;
import com.project.jimmunity.post.Post;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CommentTest {

    @Test
    public void changeContentTest(){
        //given
        Comment comment = new Comment();

        //when
        comment.changeContent("test");

        //then
        assertThat(comment.getContent()).isEqualTo("test");
    }

    @Test
    public void setOriginalPostTest(){
        //given
        Comment comment = new Comment();

        //when
        Post post = new Post();
        comment.setOriginalPost(post);

        //then
        assertThat(comment.getPost()).isEqualTo(post);
        assertThat(post.getCommentList().size()).isEqualTo(1);
    }

    @Test
    public void setOwnerTest(){
        //given
        Comment comment = new Comment();

        //when
        Member member = new Member();
        comment.setOwner(member);

        //then
        assertThat(comment.getMember()).isEqualTo(member);
        assertThat(member.getCommentList().size()).isEqualTo(1);
    }
}
