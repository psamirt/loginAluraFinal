package com.aluracursos.forohub.repository;

import com.aluracursos.forohub.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findOneByEmail(String userName);
}
