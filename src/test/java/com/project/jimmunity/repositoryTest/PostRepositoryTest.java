package com.project.jimmunity.repositoryTest;


import com.project.jimmunity.member.Member;
import com.project.jimmunity.post.Post;
import com.project.jimmunity.post.PostType;
import com.project.jimmunity.post.SearchOption;
import com.project.jimmunity.post.repository.PostRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDateTime;
import java.util.List;

import static com.project.jimmunity.post.SearchOption.*;
import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class PostRepositoryTest {

    @Autowired
    PostRepository postRepository;

    @PersistenceContext
    EntityManager em;

    @Test
    public void 이주의_핫토픽_테스트(){

        //given
        Post post1 = new Post();
        Post post2 = new Post();
        Post post3 = new Post();
        post1.changePostType(PostType.QUESTION);
        post2.changePostType(PostType.NORMAL);
        post3.changePostType(PostType.QUESTION);
        postRepository.save(post1);
        postRepository.save(post2);
        postRepository.save(post3);

        //when
        List<Post> postList = postRepository
                .searchHotTopicsOfWeekendWithType(PostType.QUESTION, LocalDateTime.now());

        //then
        assertThat(postList.size()).isEqualTo(2);

    }


    @Test
    public void search_posts_with_keyword_test(){
        //given
        Post post1 = new Post();
        Post post2 = new Post();
        Post post3 = new Post();
        Post post4 = new Post();

        post1.changeContent("test1asd");
        post2.changeContent("test2asd");
        post3.changeContent("test1asd");
        post4.changeContent("test2asd");

        post1.changeTitle("test1asd");
        post2.changeTitle("test1asd");
        post3.changeTitle("test2asd");
        post4.changeTitle("test2asd");

        postRepository.save(post1);
        postRepository.save(post2);
        postRepository.save(post3);
        postRepository.save(post4);

        em.flush();
        em.clear();

        //when
        List<Post> postList = postRepository.searchPostsWithKeyword(CONTENT, "test2");

        //then
        assertThat(postList.size()).isEqualTo(2);
    }
}
