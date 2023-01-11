package com.project.jimmunity.member.repository;

import com.project.jimmunity.member.Job;
import com.project.jimmunity.member.Member;

import java.util.List;

public interface MemberRepositoryCustom {
    public List<Member> searchMembersWithOptions(Job job, Integer age, Integer expYear);
}
