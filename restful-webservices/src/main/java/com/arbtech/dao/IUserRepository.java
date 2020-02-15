package com.arbtech.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.arbtech.model.User;

@Repository
public interface IUserRepository extends JpaRepository<User, Integer> {

}
