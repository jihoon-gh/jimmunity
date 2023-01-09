package com.project.jimmunity.entityTest;

import com.project.jimmunity.entity.Comment;
import com.project.jimmunity.entity.Member;
import com.project.jimmunity.entity.Post;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.contentOf;

public class MemberTest {

    @Test
    public void costructNewMemberWithBuilderTest(){

        //given
        String name = "test";
        String password = "test";
        String email = "test@test.com";

        //when
        Member member = Member.builder()
                .name(name)
                .password(password)
                .email(email)
                .build();

        //then
        assertThat(member.getName()).isEqualTo("test");
        assertThat(member.getPassword()).isEqualTo("test");
        assertThat(member.getEmail()).isEqualTo("test@test.com");
    }

    @Test
    public void changeProfileImgTest(){
        //given
        Member member = new Member("test", "test", "test");

        //when
        member.changeProfileImg("changedImg");

        //then
        assertThat(member.getProfileImg()).isEqualTo("changedImg");

    }
    @Test
    public void changePasswordTest(){
        //given
        Member member = new Member("test", "test", "test");

        //when
        member.changePassword("changedPassword");

        //then
        assertThat(member.getPassword()).isEqualTo("changedPassword");
    }
    @Test
    public void changeIntroductionTest(){
        //given
        Member member = new Member("test", "test", "test");

        //when
        member.changeIntroduction("changed");

        //then
        assertThat(member.getIntroduction()).isEqualTo("changed");
    }
    @Test
    public void addPostTest(){
        //given
        Member member = new Member("test", "test", "test");
        Post post = new Post();

        //when
        member.addPost(post);

        //then
        assertThat(member.getPostList().size()).isEqualTo(1);
    }
    @Test
    public void addCommentTest(){
        //given
        Member member = new Member("test", "test", "test");
        Comment comment1 = new Comment();
        Comment comment2 = new Comment();

        //when
        member.addComment(comment1);
        member.addComment(comment2);

        //then
        assertThat(member.getCommentList().size()).isEqualTo(2);
    }



}
