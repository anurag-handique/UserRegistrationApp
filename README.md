# UserRegistrationApp

UserRegistrationApp is a simple web application for user registration. It allows users to sign up by providing their basic information, including username, email address, first name, last name, phone number, and address. This application is built using Spring Boot for the REST API, Maven for dependency management, MongoDB for data storage, and HTML/CSS/JavaScript for the front-end.

## Features

- User-friendly registration form.
- Validation of user input for required fields.
- Validation to prevent registration if the username or email address already exists.
- Storage of user registration data in a MongoDB database.
- Confirmation email sent to the user upon successful registration.
- GET request to retrieve user details by username.
  
## REST APIs

### User Registration API (POST)

- **Endpoint:** `/api/register`
- **Method:** POST
- **Description:** This API allows users to register by providing their user details in the request body. It validates the input data, checks if the username or email already exists, and stores the user's registration data in the MongoDB database. If successful, it sends a confirmation email to the user.
- **Request Body:**
  - `userName` (String, required): User's username.
  - `emailAddress` (String, required): User's email address.
  - `firstName` (String): User's first name.
  - `lastName` (String): User's last name.
  - `phoneNumber` (String): User's phone number.
  - `userAddress` (String): User's address.
- **Response:** 
  - Success (HTTP Status 200): "Registration successful!"
  - Validation Error (HTTP Status 400): "Error: Please provide a valid username and email address."
  - Internal Server Error (HTTP Status 500): "Error: An error occurred during registration."

### Get User Details by Username API (GET)

- **Endpoint:** `/api/get_user/{username}`
- **Method:** GET
- **Description:** This API allows you to retrieve user details by specifying the username in the URL path. It queries the MongoDB database for user information and returns the user details if found.
- **Parameters:**
  - `{username}` (String): The username of the user you want to retrieve.
- **Response:**
  - Success (HTTP Status 200): User details in JSON format.
  - User Not Found (HTTP Status 404): "User not found for username: {username}"


## Installation

To run this project locally, follow these steps:

1. Clone the repository:

   ```bash
   git clone https://github.com/anurag-handique/UserRegistrationApp.git
