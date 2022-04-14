package com.example.demo.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Profile {
    @Id
    @GeneratedValue
    @Column(name = "PROFILE_ID")
    private Long id;

    @Column(name="PROFILE_NAME")
    private String name;

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private User user;

}
