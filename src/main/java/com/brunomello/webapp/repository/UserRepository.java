package com.brunomello.webapp.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.brunomello.webapp.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
	

}
