package com.dimitrii.maksymov.ui_service.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;



@RestController
@RequiredArgsConstructor
public class UserController {

    private final RestTemplate restTemplate;

    @GetMapping("/test/{id}")
    public ResponseEntity<User> doGet(@PathVariable Integer id) {
        return restTemplate.getForEntity("http://localhost:8081/test/" + id, User.class);
    }

    @PostMapping("/addUser")
    public ResponseEntity<User> addProduct(@RequestBody User user) {
        return restTemplate.postForEntity("http://localhost:8081/addUser", new HttpEntity<>(user), User.class);
    }

    @GetMapping("/users")
    public ResponseEntity<User[]> findAllUsers() {
        //todo List
        return restTemplate.getForEntity("http://localhost:8081/users", User[].class);
    }

    @GetMapping("/userById/{id}")
    public ResponseEntity<User> findUserById(@PathVariable int id) {
        return restTemplate.getForEntity("http://localhost:8081/userById/" + id, User.class);
    }

    @PutMapping("/update")
    public void updateProduct(@RequestBody User user) {
        //todo mb return smt
        restTemplate.put("http://localhost:8081/update", user, User.class);
    }

    record User(int id,String firstName,String secondName,boolean isblocked,String username,String password,int role_id){
    }

}
