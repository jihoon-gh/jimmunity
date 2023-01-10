package com.project.jimmunity.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@NoArgsConstructor
public class Post extends BaseEntity{

    @Id @Column(name = "post_id", columnDefinition = "BINARY(16)")
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    private UUID postId;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "post")
    private List<Comment> commentList = new ArrayList<>();


    private String title;

    private String content;

    @Builder
    public Post(Member member, String title, String content){
        setPostOwner(member);
        this.title = title;
        this.content = content;
    }

    public void setPostOwner(Member member){
        this.member = member;
        member.addPost(this);
    }
    public void addComment(Comment comment){
        this.commentList.add(comment);
    }


}
