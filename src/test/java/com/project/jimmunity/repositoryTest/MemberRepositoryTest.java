package com.project.jimmunity.repositoryTest;

import com.project.jimmunity.member.Job;
import com.project.jimmunity.member.Member;
import com.project.jimmunity.member.repository.MemberRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.PersistenceContexts;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class MemberRepositoryTest {

    @Autowired
    MemberRepository memberRepository;

    @PersistenceContext
    EntityManager em;

    @Test
    public void MemberSaveTest(){
        //given
        Member member = new Member();
        memberRepository.save(member);
        em.flush();
        em.clear();

        //when
        List<Member> result = memberRepository.findAll();

        //then
        assertThat(result.size()).isEqualTo(1);
    }

    @Test
    public void MemberSearchWithOptionsTest(){
        //given
        Member member1 = new Member("test1","test1","test1", Job.DEVELOPER);
        Member member2 = new Member("test2","test2","test2", Job.DESIGNER);
        Member member3 = new Member("test3","test3","test3", Job.STUDENT);
        Member member4 = new Member("test4","test4","test4", Job.DEVELOPER);
        memberRepository.save(member1);
        memberRepository.save(member2);
        memberRepository.save(member3);
        memberRepository.save(member4);
        em.flush();
        em.clear();

        //when
        List<Member> result = memberRepository.searchMembersWithOptions(Job.DEVELOPER, null, null);

        //then
        assertThat(result.size()).isEqualTo(2);
    }
}
