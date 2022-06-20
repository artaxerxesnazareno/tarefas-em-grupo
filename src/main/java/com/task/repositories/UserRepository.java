package com.task.repositories;

import com.task.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Entity;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
List<User> findByEmail(String email);
}
