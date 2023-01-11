package com.project.jimmunity.member.repository;

import com.project.jimmunity.member.Job;
import com.project.jimmunity.member.Member;
import com.project.jimmunity.member.QMember;
import com.project.jimmunity.post.QPost;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.AllArgsConstructor;

import java.util.List;

import static com.project.jimmunity.member.QMember.member;
import static com.project.jimmunity.post.QPost.post;

@AllArgsConstructor
public class MemberRepositoryImpl implements MemberRepositoryCustom{

    private final JPAQueryFactory queryFactory;


    @Override
    public List<Member> searchMembersWithOptions(Job job, Integer age, Integer expYear) {
        return queryFactory
                .select(member)
                .from(member)
                .where(jobEq(job), ageGte(age), expYearGte(expYear))
                .fetch();
    }

    public BooleanExpression jobEq(Job job){
        return job == null ? null : member.job.stringValue().eq(job.name());
    }

    public BooleanExpression expYearGte(Integer expYear){
        return expYear == null ? null : member.expYear.goe(expYear);
    }

    public BooleanExpression ageGte(Integer age){
        return age == null ? null : member.age.goe(age);
    }
}
