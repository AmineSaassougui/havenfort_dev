package com.camp.havenfort_dev.repository;

import com.camp.havenfort_dev.entity.ERole;
import com.camp.havenfort_dev.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
  Optional<Role> findByName(ERole name);
}
