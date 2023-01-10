package com.project.jimmunity.member.repository;

import com.project.jimmunity.member.Member;
import com.project.jimmunity.member.QMember;
import com.project.jimmunity.post.QPost;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.AllArgsConstructor;

import java.util.List;

import static com.project.jimmunity.member.QMember.member;
import static com.project.jimmunity.post.QPost.post;

@AllArgsConstructor
public class MemberRepositoryImpl implements MemberRepositoryCustom{

    private final JPAQueryFactory queryFactory;


}
