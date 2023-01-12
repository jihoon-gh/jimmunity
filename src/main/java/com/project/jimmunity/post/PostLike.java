package com.project.jimmunity.post;

import com.project.jimmunity.commonEntity.BaseTimeEntity;
import com.project.jimmunity.member.Member;
import jakarta.persistence.*;

@Entity
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
}
