package org.mcyldz.questapp.repository;

import org.mcyldz.questapp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository <User, Integer> {
    User findByUserName(String userName);
}
