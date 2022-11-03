package com.app.dasher.repository;

import com.app.dasher.models.user.UsersInfo;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<UsersInfo, String> {

    UsersInfo findByEmail(String emailId);

    Optional<UsersInfo> findById(String username);

    Boolean existsByEmail(String email);

}
