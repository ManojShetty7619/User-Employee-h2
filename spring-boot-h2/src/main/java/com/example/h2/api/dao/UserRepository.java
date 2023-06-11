package com.example.h2.api.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.h2.api.model.UserDetails;

@Repository
public interface UserRepository extends JpaRepository<UserDetails, Integer> {

	UserDetails findByUserFirstname(String userName);

	UserDetails findByUserLastName(String userLastName);

}
