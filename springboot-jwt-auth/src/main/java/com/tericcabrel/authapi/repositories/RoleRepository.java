package com.tericcabrel.authapi.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tericcabrel.authapi.entities.Role;
import com.tericcabrel.authapi.entities.RoleEnum;
@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
    Optional<Role> findByName(RoleEnum name);


}
