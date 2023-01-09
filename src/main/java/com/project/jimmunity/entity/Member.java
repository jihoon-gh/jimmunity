package com.project.jimmunity.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
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

    @Column(columnDefinition = "TEXT")
    private String introduction;

    @OneToMany(mappedBy = "member")
    private List<Post> postList = new ArrayList<>();

    @OneToMany(mappedBy = "member")
    private List<Comment> commentList = new ArrayList<>();

    @Builder
    public Member(String email, String password, String name) {
        this.email = email;
        this.password = password;
        this.name = name;
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


}
