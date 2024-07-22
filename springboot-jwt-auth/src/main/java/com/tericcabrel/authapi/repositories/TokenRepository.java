package com.tericcabrel.authapi.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.tericcabrel.authapi.entities.TokenDetail;
@Repository
public interface TokenRepository extends JpaRepository<TokenDetail, Integer> {
    Optional<TokenDetail> findByEmail(String email);


}
