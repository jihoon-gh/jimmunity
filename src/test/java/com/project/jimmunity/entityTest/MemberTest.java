package com.project.jimmunity.entityTest;

import com.project.jimmunity.comment.Comment;
import com.project.jimmunity.member.Job;
import com.project.jimmunity.member.Member;
import com.project.jimmunity.post.Post;
import org.junit.jupiter.api.Test;

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
        Member member = new Member("test", "test", "test", Job.OTHER);

        //when
        member.changeProfileImg("changedImg");

        //then
        assertThat(member.getProfileImg()).isEqualTo("changedImg");

    }
    @Test
    public void changePasswordTest(){
        //given
        Member member = new Member("test", "test", "test", Job.OTHER);

        //when
        member.changePassword("changedPassword");

        //then
        assertThat(member.getPassword()).isEqualTo("changedPassword");
    }
    @Test
    public void changeIntroductionTest(){
        //given
        Member member = new Member("test", "test", "test", Job.OTHER);

        //when
        member.changeIntroduction("changed");

        //then
        assertThat(member.getIntroduction()).isEqualTo("changed");
    }
    @Test
    public void addPostTest(){
        //given
        Member member = new Member("test", "test", "test", Job.OTHER);
        Post post = new Post();

        //when
        member.addPost(post);

        //then
        assertThat(member.getPostList().size()).isEqualTo(1);
    }
    @Test
    public void addCommentTest(){
        //given
        Member member = new Member("test", "test", "test", Job.OTHER);
        Comment comment1 = new Comment();
        Comment comment2 = new Comment();

        //when
        member.addComment(comment1);
        member.addComment(comment2);

        //then
        assertThat(member.getCommentList().size()).isEqualTo(2);
    }

    @Test
    public void changeJobTest(){
        //given
        Member member = new Member();
        Job j = Job.STUDENT;

        //when
        member.changeJob(j);

        //then
        assertThat(member.getJob()).isEqualTo(Job.STUDENT);
    }
    @Test
    public void changeExpYearTest(){
        //given
        Member member = new Member();
        Integer expYear = 5;

        //when
        member.changeExpYear(expYear);

        //then
        assertThat(member.getExpYear()).isEqualTo(5);
    }
    @Test
    public void changeAgeTest(){
        //given
        Member member = new Member();
        Integer age = 20;

        //when
        member.changeAge(age);

        //then
        assertThat(member.getAge()).isEqualTo(20);
    }


}
