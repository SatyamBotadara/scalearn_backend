package com.scalearn.repository;

import com.scalearn.entity.ScalearnUser;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface ScalearnUserRepo extends MongoRepository<ScalearnUser,String> {
    Optional<ScalearnUser> findByEmailId(String emailId);
}