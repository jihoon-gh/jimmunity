package com.project.jimmunity.post;

import com.project.jimmunity.commonEntity.BaseTimeEntity;
import com.project.jimmunity.member.Member;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class PostLike extends BaseTimeEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_like_id")
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id")
    private Post post;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    public PostLike(Member member, Post post){
        this.member = member;
        member.addPostLike(this);
        this.post = post;
        post.addPostLike(this);
    }

}
