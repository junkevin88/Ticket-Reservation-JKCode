package com.jkcode.reservation.entity;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.*;


@SpringBootTest
public class UserTest {

    @Test
    public void testGetIdAndSetId() {
        // Create a new User instance
        User user = new User();

        // Set the ID using the setId method
        user.setId(1L);

        // Verify that the ID can be retrieved correctly using the getId method
        assertEquals(1L, user.getId().longValue());
    }

    @Test
    public void testGetFirstNameAndSetFirstName() {
        // Create a new User instance
        User user = new User();

        // Set the first name using the setFirstName method
        user.setFirstName("John");

        // Verify that the first name can be retrieved correctly using the getFirstName method
        assertEquals("John", user.getFirstName());
    }

    @Test
    public void testGetLastNameAndSetLastName() {
        // Create a new User instance
        User user = new User();

        // Set the last name using the setLastName method
        user.setLastName("Doe");

        // Verify that the last name can be retrieved correctly using the getLastName method
        assertEquals("Doe", user.getLastName());
    }

    @Test
    public void testGetEmailAndSetEmail() {
        // Create a new User instance
        User user = new User();

        // Set the email using the setEmail method
        user.setEmail("john.doe@example.com");

        // Verify that the email can be retrieved correctly using the getEmail method
        assertEquals("john.doe@example.com", user.getEmail());
    }

    @Test
    public void testGetPasswordAndSetPassword() {
        // Create a new User instance
        User user = new User();

        // Set the password using the setPassword method
        user.setPassword("password");

        // Verify that the password can be retrieved correctly using the getPassword method
        assertEquals("password", user.getPassword());
    }
}

