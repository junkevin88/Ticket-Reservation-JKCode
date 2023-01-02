package com.jkcode.reservation.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import com.jkcode.reservation.entity.User;
import com.jkcode.reservation.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserServiceImpl userService;

    @Test
    void testGetAllUsers() {
        List<User> expectedUsers = Arrays.asList(new User(), new User());
        when(userRepository.findAll()).thenReturn(expectedUsers);

        List<User> actualUsers = userService.getAllUsers();
        assertEquals(expectedUsers, actualUsers);
    }

    @Test
    void testGetUserById() {
        User expectedUser = new User();
        when(userRepository.findById(1L)).thenReturn(Optional.of(expectedUser));

        User actualUser = userService.getUserById(1L);
        assertEquals(expectedUser, actualUser);
    }

    @Test
    void testCreateUser() {
        User user = new User();
        when(userRepository.save(user)).thenReturn(user);

        User actualUser = userService.createUser(user);
        assertEquals(user, actualUser);
    }

    @Test
    void testUpdateUser() {
        User user = new User();
        when(userRepository.findById(1L)).thenReturn(Optional.of(user));
        when(userRepository.save(user)).thenReturn(user);

        User actualUser = userService.updateUser(1L, user);
        assertEquals(user, actualUser);
    }

    @Test
    void testDeleteUser() {
        User user = new User();
        when(userRepository.findById(1L)).thenReturn(Optional.of(user));

        userService.deleteUser(1L);
        assertTrue(user.getDeleted());
        verify(userRepository).save(user);
    }

}
