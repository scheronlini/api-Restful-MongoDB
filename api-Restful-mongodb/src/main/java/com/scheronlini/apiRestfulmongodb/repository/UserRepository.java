package com.scheronlini.apiRestfulmongodb.repository;

import com.scheronlini.apiRestfulmongodb.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String>{

}
