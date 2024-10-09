package com.github.syndexmx.demobudget.domain;

public class TestDataUser {

    public static final String testUserName = "JohnConnor";
    public static final String testUserEmail = "connorj85@gmail.com";

    public static final UserDto testUserDto = UserDto.builder()
            .userName(testUserName)
            .email(testUserEmail)
            .build();

    public static final User testUser = User.builder()
            .userName(testUserName)
            .email(testUserEmail)
            .build();

    public static final UserEntity testUserEntity = UserEntity.builder()
            .userName(testUserName)
            .email(testUserEmail)
            .build();
}
