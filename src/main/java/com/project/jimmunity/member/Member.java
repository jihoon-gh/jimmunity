package com.project.jimmunity.member;

import com.project.jimmunity.comment.CommentLike;
import com.project.jimmunity.commonEntity.BaseTimeEntity;
import com.project.jimmunity.comment.Comment;
import com.project.jimmunity.post.Post;
import com.project.jimmunity.post.PostLike;
import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@NoArgsConstructor
public class Member extends BaseTimeEntity {

    @Id @Column(name = "member_id", columnDefinition = "BINARY(16)")
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    private UUID id;
    private String email;
    private String password;
    private String name;
    private String profileImg;
    @Enumerated(EnumType.STRING)
    private Job job;
    private Integer expYear;
    private Integer age;
    @Column(columnDefinition = "TEXT")
    private String introduction;

    @OneToMany(mappedBy = "member")
    private List<Post> postList = new ArrayList<>();
    @OneToMany(mappedBy = "member")
    private List<Comment> commentList = new ArrayList<>();

    @OneToMany(mappedBy = "member",cascade = CascadeType.ALL)
    private List<PostLike> postLikeList = new ArrayList<>();

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<CommentLike> commentLikeList = new ArrayList<>();

    @Builder //절대 null이면 안되는 값들의 초기화를 강제
    public Member(String email, String password, String name, Job job) {
        this.email = email;
        this.password = password;
        this.name = name;
        changeJob(job);
    }

    public void changePassword(String password){
        this.password = password;
    }

    public void changeProfileImg(String profileImg){
        this.profileImg = profileImg;
    }

    public void changeIntroduction(String introduction){
        this.introduction = introduction;
    }

    public void addPost(Post post){
        this.postList.add(post);
    }

    public void addComment(Comment comment){
        this.commentList.add(comment);
    }

    public void changeAge(Integer age){
        this.age = age;
    }

    public void changeJob(Job job){
        this.job = job;
    }

    public void changeExpYear(Integer expYear){
        this.expYear = expYear;
    }

    public void addCommentLike(CommentLike commentLike){
        this.commentLikeList.add(commentLike);

    }

    public void addPostLike(PostLike postLike) {
        this.postLikeList.add(postLike);
    }
}
