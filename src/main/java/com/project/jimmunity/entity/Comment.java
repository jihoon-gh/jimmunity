package com.project.jimmunity.entity;

import jakarta.persistence.*;
import lombok.Getter;
import org.hibernate.annotations.GenericGenerator;

import java.util.UUID;

@Entity
@Getter
public class Comment extends BaseEntity{

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




    public void changeContent(String content){
        this.content = content;
    }
}
