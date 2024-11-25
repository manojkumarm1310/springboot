package com.wipro.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wipro.model.BlogComment;

@Repository
public interface BlogCommentRepository extends JpaRepository<BlogComment, Long> {

	List<BlogComment> findByPostIdOrderByCreatedAtDesc(Long id);
}

