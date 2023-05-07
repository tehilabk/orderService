package com.consumerservice.model.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
//@Builder
@Entity
public class UserModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    private String email;
    private String firstName;
    private String lastName;

    public UserModel() {

    }

    public UserModel(String email, String firstName, String lastName) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
    }

}

