package com.github.syndexmx.demobudget.services.Impl;

import com.github.syndexmx.demobudget.domain.User;
import com.github.syndexmx.demobudget.domain.UserEntity;
import com.github.syndexmx.demobudget.repositories.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserServiceImpl underTest;

    @Test
    public void testThatUserIsSaved() {
        final User user = User.builder()
                .userName("JohnConnor")
                .email("connorj85@gmail.com")
                .build();
        final UserEntity userEntity = UserEntity.builder()
                .userName("JohnConnor")
                .email("connorj85@gmail.com")
                .build();
        when(userRepository.save(eq(userEntity))).thenReturn(userEntity);
        final User resultUser = underTest.create(user);
        assertEquals(user, resultUser);
    }
}