package com.pai.pms.model.repository;

import java.util.Optional;

import com.pai.pms.model.entities.Role;
import com.pai.pms.model.enums.ERole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);
}
