package com.waitlist.signup.entity;

import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Class containing the user info
 */
@Document(collection = "users")
public class UserDetails {

    /**
     * Initialise the variables to store user details
     */
    private String _id;
    private String firstName;
    private String lastname;
    private String userName;
    private String phoneNumber;
    private String emailAddress;
    private String userAddress;

    /**
     * Constructor
     */
    public UserDetails(String _id, String firstName, String lastname, String userName, String phoneNumber, String emailAddress, String userAddress) {
        this._id = _id;
        this.firstName = firstName;
        this.lastname = lastname;
        this.userName = userName;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
        this.userAddress = userAddress;
    }

    /**
     * Default  Constructor
     */
    public UserDetails() {
    }

    /**
     * Getters and Setters
     */
    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    /**
     * ToString Method
     */
    @Override
    public String toString() {
        return "UserDetails{" + "_id='" + _id + '\'' + ", firstName='" + firstName + '\'' + ", lastname='" + lastname + '\'' + ", userName='" + userName + '\'' + ", phoneNumber='" + phoneNumber + '\'' + ", emailAddress='" + emailAddress + '\'' + ", userAddress='" + userAddress + '\'' + '}';
    }
}
