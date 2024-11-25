package com.wipro.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wipro.model.BlogComment;

@Repository
public interface BlogCommentDAO extends JpaRepository<BlogComment, Integer> {

	List<BlogComment> findByPostIdOrderByCreatedAtDesc(Integer id);

}
