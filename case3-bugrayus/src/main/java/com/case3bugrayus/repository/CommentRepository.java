package com.case3bugrayus.repository;

import com.case3bugrayus.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> getAllByUserId(long userId);

    List<Comment> getAllByProductId(long productId);
}
