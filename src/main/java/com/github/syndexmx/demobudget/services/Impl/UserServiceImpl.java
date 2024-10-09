package com.github.syndexmx.demobudget.services.Impl;

import com.github.syndexmx.demobudget.domain.User;
import com.github.syndexmx.demobudget.domain.UserEntity;
import com.github.syndexmx.demobudget.repositories.UserRepository;
import com.github.syndexmx.demobudget.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(final UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User create(User user) {
        final UserEntity savedUserEntity = userRepository.save(UserToUserEntity(user));
        final User savedUser = UserEntityToUser(savedUserEntity);
        return savedUser;
    }

    @Override
    public boolean isPresent(String userName) {
        return userRepository.findById(userName).isPresent();
    }

    private UserEntity UserToUserEntity(User user) {
        return UserEntity.builder()
                .userName(user.getUserName())
                .email(user.getEmail())
                .build();
    }

    private User UserEntityToUser(UserEntity userEntity) {
        return User.builder()
                .userName(userEntity.getUserName())
                .email(userEntity.getEmail())
                .build();
    }

}
