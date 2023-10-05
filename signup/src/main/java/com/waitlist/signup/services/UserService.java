package com.waitlist.signup.services;

import com.waitlist.signup.db.UserDatabase;
import com.waitlist.signup.entity.UserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    /**
     * Injected UserDatabase for user data operations.
     */
    @Autowired
    private UserDatabase database;

    /**
     * Save the user in the database
     */
    public void saveUser(UserDetails userDetails) {
        database.save(userDetails);
    }

    /**
     * Find a user by their userName
     *
     * @param userName The userName to search for
     * @return The UserDetails object if found, or null if not found
     */
    public UserDetails findByUserName(String userName) {
        return database.findByUserName(userName);
    }

    public boolean userExists(String userName, String emailAddress) {
        // Check if a user with the given userName or emailAddress already exists in the database
        UserDetails userWithUserName = database.findByUserName(userName);
        UserDetails userWithEmailAddress = database.findByEmailAddress(emailAddress);

        return userWithUserName != null || userWithEmailAddress != null;
    }
}
