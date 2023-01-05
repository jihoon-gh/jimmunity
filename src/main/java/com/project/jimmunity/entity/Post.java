package com.project.jimmunity.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.UUID;

@Entity
public class Post extends BaseEntity{

    @Id @Column(name = "post_id", columnDefinition = "BINARY(16)")
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    private UUID postId;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    private String title;

    private String content;


}
