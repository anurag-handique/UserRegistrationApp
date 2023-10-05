package com.waitlist.signup.controller;

import com.waitlist.signup.entity.UserDetails;
import com.waitlist.signup.services.EmailService;
import com.waitlist.signup.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api")
public class UserController {

    /**
     * Inject UserService dependency
     */
    @Autowired
    private UserService userService;

    /**
     * Inject EmailService dependency
     */
    @Autowired
    private EmailService emailService;

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody UserDetails userDetails) {
        try {
            /**
             * Check if any of the required fields are empty
             */
            if (userDetails == null || userDetails.getUserName() == null || userDetails.getUserName().isEmpty() || userDetails.getEmailAddress() == null || userDetails.getEmailAddress().isEmpty()) {
                return ResponseEntity.badRequest().body("Error: Please provide a valid username and email address.");
            }

            /**
             * Check if the username or email already exist in the database
             */
            if (userService.userExists(userDetails.getUserName(), userDetails.getEmailAddress())) {
                return ResponseEntity.badRequest().body("Error: Username or email address already exists.");
            }

            /**
             *  Save the username in the Database
             */
            userService.saveUser(userDetails);

            /**
             * Send a registration email
             */
            emailService.sendRegistrationEmail(userDetails.getEmailAddress(), "Welcome to OpenCourse - Registration Successful", "Dear " + userDetails.getFirstName() + ",\n\n" + "Thank you for registering with OpenCourse. Your registration was successful!\n" + "Here are your registration details:\n\n" + "Username: " + userDetails.getUserName() + "\n" + "Email: " + userDetails.getEmailAddress() + "\n\n" + "Welcome to OpenCourse, your gateway to online education!\n\n" + "Sincerely,\nThe OpenCourse Team");

            /**
             * Return a success response
             */
            return ResponseEntity.ok("Registration successful!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error: An error occurred during registration.");
        }
    }

    /**
     * Method to get user details
     */
    @GetMapping(value = "/get_user/{userName}")
    public ResponseEntity<?> getUserDetails(@PathVariable String userName) {
        UserDetails userDetails = userService.findByUserName(userName);

        if (userDetails != null) {
            /**
             * Return user details if found
             */
            return ResponseEntity.ok(userDetails);
        } else {
            /**
             * Return "User not found" response with a  message
             */
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found for username: " + userName);
        }

    }


}
