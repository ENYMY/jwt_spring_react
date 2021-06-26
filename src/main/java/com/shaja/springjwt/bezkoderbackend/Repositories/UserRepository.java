package com.shaja.springjwt.bezkoderbackend.Repositories;

import com.shaja.springjwt.bezkoderbackend.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Long, User> {
}
