package com.shaja.springjwt.bezkoderbackend.Repositories;

import com.shaja.springjwt.bezkoderbackend.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Long, Role> {
}
