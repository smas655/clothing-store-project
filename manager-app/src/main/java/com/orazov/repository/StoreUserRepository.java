package com.orazov.repository;

import com.orazov.entity.StoreUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StoreUserRepository extends CrudRepository<StoreUser, Integer> {

    Optional<StoreUser> findByUsername(String username);
}
