package com.github.syndexmx.demobudget.services;

import com.github.syndexmx.demobudget.domain.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    User create(User user);
}
