package com.arbtech.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.arbtech.model.Post;

/**
 * Post Repository for Post model 
 * @author Aniket Bharsakale
 */
@Repository
public interface IPostRepository extends JpaRepository<Post, Integer> {

}
