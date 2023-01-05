package com.project.jimmunity.entityTest;

import com.project.jimmunity.entity.Member;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class MemberTest {


    @PersistenceContext
    EntityManager em;

    @Test
    public void 멤버_생성시_uuid_test(){

        //given
        Member member1 = new Member("test@test","test","test1");
        Member member2 = new Member("test@test","test","test2");

        em.persist(member1);
        em.persist(member2);

        em.flush();
        em.clear();

        //when
        List<Member> result = em.createQuery("select m from Member m", Member.class)
                .getResultList();

        //then
        assertThat(result.get(0).getId()).isNotEqualTo(result.get(1).getId());
        System.out.println("uuid1 = " + result.get(0).getId());
        System.out.println("uuid2 = " + result.get(1).getId());

    }

    @Test
    public void 비밀번호_변경_테스트(){
        //given
        Member member = new Member("test@test","test","test1");
        em.persist(member);
        em.flush();
        em.clear();

        //when
        Member findMember = em.createQuery("select m from Member m where m.name =: test1",Member.class)
                .setParameter("test1","test1")
                .getSingleResult();

        findMember.changePassword("changedPassword");
        em.flush();
        em.clear();

        Member result = em.createQuery("select m from Member m where m.name =: test1",Member.class)
                .setParameter("test1","test1")
                .getSingleResult();

        //then
        assertThat(result.getPassword()).isEqualTo("changedPassword");
    }

}
