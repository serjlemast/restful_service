package com.dimitrii.maksymov.user_service.controller;

import com.dimitrii.maksymov.user_service.entity.User;
import com.dimitrii.maksymov.user_service.service.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


//TODO 1.PAGINABLE ONJ(SORT,ORDER...)
//2.EXEPTION HANDLER CUSTOM EXEPTION
//3.yaml validate (add error handler)
//4.ADD SWAGGER
//5.mapper custom DTO
//6.active actuator(spring boot)
//7.SPRING BOOT ADMINISTRATION
//8.DB MIGRATION (LIQUED BASE , FLY WAY)
//9.ENUM ROLES (STRATEGORY HIBERNATE для еним типов)
//10. hibernate one to many
//todo STATEGORY
@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserServiceImpl userService;

    @PostMapping("/addUser")
    public ResponseEntity<User> addProduct(@RequestBody User user) {
        return ResponseEntity.ok(userService.saveUser(user));
    }


    @GetMapping("/users")
    public ResponseEntity<Page<User>> findAllUsers(@PageableDefault(sort = {"id"}, direction = Sort.Direction.ASC) Pageable pageable) {
        return ResponseEntity.ok(userService.getUsers(pageable));
    }

    @GetMapping("/userById/{id}")
    public ResponseEntity<User> findUserById(@PathVariable int id) {
        return ResponseEntity.ok(userService.getUserById(id));
    }

    @GetMapping("/userBy")
    public ResponseEntity<Page<User>> findUserById(@RequestParam String username, @RequestParam String password,
                                                   @PageableDefault(sort = {"id"}, direction = Sort.Direction.ASC) Pageable pageable) {
        return ResponseEntity.ok(userService.getUserByCredentials(username, password, pageable));
    }


//    @PutMapping("/update")
//    public ResponseEntity<User> updateProduct(@RequestBody User user) {
//        return ResponseEntity.ok(userService.updateUser(user));
//    }

//    @GetMapping("/test/{id}")
//    public ResponseEntity<User> doGet(@PathVariable Integer id) {
//        User user = new User();
//        user.setId(id);
//        user.setFirstName("First name" + id);
//        return ResponseEntity.ok(user);
//    }
}
