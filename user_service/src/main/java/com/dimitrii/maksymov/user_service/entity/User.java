package com.dimitrii.maksymov.user_service.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

//import jakarta.persistence.*;
import javax.persistence.*;



@Data
//@Data just for testing
//remove data!!!
@NoArgsConstructor
@Entity
@Table(name = "users_table")
public class User {
    @Id
    private int id;
    @Column(name = "first_name",nullable = true)
    private String firstName;
    @Column(name = "second_name",nullable = true)
    private String lastName;
    @Column(name = "username",nullable = false)
    private String username;
    @Column(name = "password",nullable = false)
    private String password;

}