package com.project.jimmunity.member.repository;

import com.project.jimmunity.member.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface MemberRepository extends JpaRepository<Member, UUID>, MemberRepositoryCustom {

}
