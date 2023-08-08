package com.user.service.service;

import com.user.service.entity.User;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
@Component
public interface UserService {
    User saveUser(User user);
    List<User>getAllUser();
    User getUser(String userId);
}
