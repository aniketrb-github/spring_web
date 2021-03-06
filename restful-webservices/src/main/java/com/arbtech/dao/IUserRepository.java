package com.arbtech.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.arbtech.model.User;
/**
 * User Repository for User model
 * @author Aniket Bharsakale
 */
@Repository
public interface IUserRepository extends JpaRepository<User, Integer> {

}
