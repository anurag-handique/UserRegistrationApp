package com.waitlist.signup.db;

import com.waitlist.signup.entity.UserDetails;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserDatabase extends MongoRepository<UserDetails, String> {

    UserDetails findByUserName(String userName);

    UserDetails findByEmailAddress(String emailAddress);
    /**
     * Class to connect with the database
     */
}
