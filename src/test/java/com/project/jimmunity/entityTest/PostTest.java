package com.project.jimmunity.entityTest;

import com.project.jimmunity.comment.Comment;
import com.project.jimmunity.member.Member;
import com.project.jimmunity.post.Post;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PostTest {

    @Test
    public void CreatePostWithBuilderTest(){
        //when
        Member member = new Member("test1","test1","test1");
        String title = "test";
        String content = "test";

        //then
        Post post = new Post().builder()
                .member(member)
                .title(title)
                .content(content)
                .build();

        //given
        assertThat(post.getMember().getName()).isEqualTo("test1");
        assertThat(post.getTitle()).isEqualTo("test");
        assertThat(post.getContent()).isEqualTo("test");

    }

    @Test
    public void setPostOwnerTest(){
        //given
        Member member = new Member();
        Post post = new Post(member,"test","test");

        //when

        //then
        assertThat(post.getMember()).isEqualTo(member);
        assertThat(member.getPostList().size()).isEqualTo(1);
    }
    @Test
    public void addCommentTest(){
        //given
        Post post = new Post();

        //when
        Comment comment1 = new Comment();
        Comment comment2 = new Comment();
        post.addComment(comment1);
        post.addComment(comment2);

        //then
        assertThat(post.getCommentList().size()).isEqualTo(2);
    }
}
