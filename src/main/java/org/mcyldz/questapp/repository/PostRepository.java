package org.mcyldz.questapp.repository;

import org.mcyldz.questapp.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface PostRepository extends JpaRepository<Post, Integer> {

    List<Post> findByUserId(Integer userId);

    @Query(value = "select id from post where user_id = :userId order by create_date desc limit 5", nativeQuery = true)
    List<Integer> findTopByUserId(@Param("userId") Integer userId);
}
