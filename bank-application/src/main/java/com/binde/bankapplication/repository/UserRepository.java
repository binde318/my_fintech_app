package com.binde.bankapplication.repository;


import com.binde.bankapplication.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
    Boolean existsByEmail(String email);

    boolean existsByAccountNumber(String accountNumber);

    User findByAccountNumber(String accountNumber);

}
