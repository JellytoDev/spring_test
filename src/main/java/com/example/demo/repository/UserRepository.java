package com.example.demo.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
@RequiredArgsConstructor
public class UserRepository {
    // DAO : Data Access Object

    public final EntityManager em;

    public void save() {

    }
}
