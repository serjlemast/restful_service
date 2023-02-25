package com.dimitrii.maksymov.user_service.service;

import com.dimitrii.maksymov.user_service.entity.User;
import com.dimitrii.maksymov.user_service.exeption.ApplicationException;
import com.dimitrii.maksymov.user_service.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository repository;

    public User saveUser(User user) {
        return repository.save(user);
    }

    public Page<User> getUsers(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public User getUserById(int id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Page<User> getUserByCredentials(String username,String password,Pageable pageable) {
        return repository.findAllByUsernameContainingIgnoreCaseAndPasswordContainingIgnoreCase(username,password,pageable);
    }

//    public User updateUser(User user) {
//        User existingUser = repository.findById(user.getId()).orElse(null);
//        User build = existingUser.builder()
//                .id(user.getId())
//                .firstName(user.getFirstName())
//                .secondName(user.getSecondName())
//                .username(user.getUsername())
//                .password(user.getPassword())
//                .isblocked(user.isIsblocked())
//                .build();
//        return repository.save(build);
//    }
}
