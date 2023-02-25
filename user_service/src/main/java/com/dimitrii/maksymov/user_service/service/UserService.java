package com.dimitrii.maksymov.user_service.service;

import com.dimitrii.maksymov.user_service.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserService {

    public User saveUser(User user);

    public Page<User> getUsers(Pageable pageable);

    public User getUserById(int id);
    public Page<User> getUserByCredentials(String username,String password,Pageable pageable);

}
