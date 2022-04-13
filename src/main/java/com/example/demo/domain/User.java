package com.example.demo.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
@Entity
@Builder
public class User {
    @Id
    private Long id;
    @Column(name="user_name")
    private String name;
    @Column(name="user_age")
    private int age;

    public User() {

    }

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
