package com.kibrom.student_id_system.repository;


import com.kibrom.student_id_system.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;



public interface UserRepository extends JpaRepository<User, Long> {


    Optional<User> findByUsername(String username);


}