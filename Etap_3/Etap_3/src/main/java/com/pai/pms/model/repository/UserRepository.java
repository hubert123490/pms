package com.pai.pms.model.repository;

import com.pai.pms.model.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface UserRepository  extends JpaRepository<User,Integer> {
    Boolean existsByEmail(String email);

    Optional<User> findByEmail(String email);
}
