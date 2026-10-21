package org.example.repository;

import org.example.entities.UserRoleMapping;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UsersRoleRepository extends JpaRepository<UserRoleMapping, Long> {

    // ✅ Spring maps this to: userRoleMapping.getUserRole().getName()
    Optional<UserRoleMapping> findByUserRoleName(String name);
}
