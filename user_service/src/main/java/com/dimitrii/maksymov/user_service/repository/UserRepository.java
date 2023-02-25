package com.dimitrii.maksymov.user_service.repository;

import com.dimitrii.maksymov.user_service.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;



public interface UserRepository extends JpaRepository<User,Integer> {

    Page<User> findAll(Pageable pageable);

    Page<User> findAllByUsernameContainingIgnoreCaseAndPasswordContainingIgnoreCase(String username,String password,Pageable pageable);


}
