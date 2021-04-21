package com.pai.pms.model.repository;

import com.pai.pms.model.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository  extends JpaRepository<User,Integer> {
}
