package org.example.auth;


import org.example.entities.UserRole;
import org.example.repository.UserRoleRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RoleConfig {

    @Bean
    CommandLineRunner createRoles(UserRoleRepository roleRepository) {

        return args -> {

            createRole(roleRepository, "CUSTOMER");
            createRole(roleRepository, "RESTAURANT_OWNER");
            createRole(roleRepository, "RESTAURANT_MANAGER");
            createRole(roleRepository, "STAFF");
            createRole(roleRepository, "DELIVERY_PARTNER");
            createRole(roleRepository, "ADMIN");
            createRole(roleRepository, "SUPER_ADMIN");
        };
    }

    private void createRole(
            UserRoleRepository roleRepository,
            String roleName
    ) {

        if (roleRepository.findByName(roleName).isEmpty()) {

            UserRole role = new UserRole();
            role.setName(roleName);

            roleRepository.save(role);
        }
    }
}
