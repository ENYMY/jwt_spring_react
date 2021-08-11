package com.shaja.springjwt.bezkoderbackend.Repositories;

import com.shaja.springjwt.bezkoderbackend.models.ARole;
import com.shaja.springjwt.bezkoderbackend.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Optional<Role> findByName(ARole role);
}
