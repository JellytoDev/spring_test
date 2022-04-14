package com.example.demo.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
public class User {
    @Id
    @GeneratedValue
    @Column(name = "user_id")
    private Long id;
    @Column(name="user_name")
    private String name;
    @Column(name="user_age")
    private int age;

    @Column(name = "user_profile")
    @OneToMany(mappedBy = "user")
    private List<Profile> profile;

    public User() {

    }

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
