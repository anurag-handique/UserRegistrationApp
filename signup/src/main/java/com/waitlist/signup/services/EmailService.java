package com.waitlist.signup.services;

import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import org.springframework.stereotype.Service;

import java.util.Properties;

@Service
public class EmailService {

    /**
     * Send Email to the user after successful registration
     */

    /**
     * @param recipientEmail
     * @param subject
     * @param messageBody
     */
    public void sendRegistrationEmail(String recipientEmail, String subject, String messageBody) {
        /**
         * Email configuration
         */
        final String senderEmail = "set_your_email_here";
        final String senderPassword = "set_your_app_password_here";

        Properties properties = new Properties();
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");

        /**
         * Create a new session for sending email using JavaMail,
         * configuring it with the specified properties, and providing-
         * -an Authenticator to handle SMTP server authentication
         */
        Session session = Session.getInstance(properties, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(senderEmail, senderPassword);
            }
        });

        try {
            /**
             * Create a new MimeMessage using the established session
             */
            Message message = new MimeMessage(session);
            /**
             * Set the sender's email address
             */
            message.setFrom(new InternetAddress(senderEmail));
            /**
             *  Set the recipient's email address
             */
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipientEmail));
            /**
             *  Set the email subject
             */
            message.setSubject(subject);
            /**
             * Set the email message body
             */
            message.setText(messageBody);
            /**
             * Send the email message using the Transport class
             */
            Transport.send(message);
            /**
             * Print a success message to the console
             */
            System.out.println("Email sent successfully to: " + recipientEmail);
        } catch (MessagingException e) {
            /**
             * Handle any exceptions that may occur during the email sending process
             */
            e.printStackTrace();
        }
    }
}
