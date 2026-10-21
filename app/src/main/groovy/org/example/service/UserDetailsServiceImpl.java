package org.example.service;

import lombok.AllArgsConstructor;
import org.example.entities.UserInfo;
import org.example.entities.UserRole;
import org.example.entities.UserRoleMapping;
import org.example.model.UserInfoDto;
import org.example.repository.UserRepository;
import org.example.repository.UserRoleRepository;
import org.example.repository.UsersRoleRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@Service // ✅ Better semantics for business logic layer than @Component
@AllArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;
    private final UsersRoleRepository usersRoleRepository;
    private final UserRoleRepository userRoleRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserInfo userInfo = userRepository.findByUsername(username);
        if (userInfo == null) {
            throw new UsernameNotFoundException("Could not find user");
        }
        return new CustomUserDetails(userInfo);
    }

    public UserInfo checkIfUserAlreadyExists(String username) {
        return userRepository.findByUsername(username);
    }

    @Transactional // ✅ Guarantees both User and Mapping records commit together
    public Boolean singupUser(UserInfoDto userInfoDto) {
        // 1. Check uniqueness using plain string username
        if (Objects.nonNull(checkIfUserAlreadyExists(userInfoDto.getUsername()))) {
            return false;
        }

        // 2. Fetch all role objects matching the text input names
        Set<UserRole> assignedRoles = userInfoDto.getRoles().stream()
                .map(roleName -> userRoleRepository.findByName(roleName.getName())
                        .orElseThrow(() -> new RuntimeException("Error: Role '" + roleName + "' not found.")))
                .collect(Collectors.toSet());

        // 3. Construct and save base user entity
        UserInfo mUserInfo = UserInfo.builder()
                .username(userInfoDto.getUsername())
                .password(passwordEncoder.encode(userInfoDto.getPassword()))
                .build();

        UserInfo savedUser = userRepository.save(mUserInfo);

        // 4. Save individual connection links using .forEach() so they execute immediately
        assignedRoles.forEach(userRole -> {
            UserRoleMapping mapping = UserRoleMapping.builder()
                    .userInfo(savedUser)
                    .userRole(userRole)
                    .build();
            usersRoleRepository.save(mapping);
        });

        return true;
    }
}
