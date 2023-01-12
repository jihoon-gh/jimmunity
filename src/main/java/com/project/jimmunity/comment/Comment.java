package com.project.jimmunity.comment;

import com.project.jimmunity.member.Member;
import com.project.jimmunity.commonEntity.BaseEntity;
import com.project.jimmunity.post.Post;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@NoArgsConstructor
public class Comment extends BaseEntity {

    @Id @Column(name = "comment_id", columnDefinition = "BINARY(16)")
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    private UUID id;
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id")
    private Post post;

    @OneToMany(mappedBy = "comment", cascade = CascadeType.ALL)
    private List<CommentLike> commentLikeList = new ArrayList<>();

    public Comment(Member member, Post post, String content){
        setOwner(member);
        setOriginalPost(post);
        changeContent(content);
    }

    public void changeContent(String content){
        this.content = content;
    }

    public void setOwner(Member member){
        this.member = member;
        member.addComment(this);
    }

    public void setOriginalPost(Post post){
        this.post = post;
        post.addComment(this);
    }

    public void addCommentLike(CommentLike commentLike){
        commentLikeList.add(commentLike);
    }

}
