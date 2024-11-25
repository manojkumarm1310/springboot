package com.wipro.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wipro.model.BlogPost;


@Repository
public interface BlogPostDAO extends JpaRepository<BlogPost, Integer>{

}
