package org.example.entities;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "users_role")
@NoArgsConstructor
@Data
public class UserRoleMapping {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private UserInfo userInfo;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "role_id", nullable = false)
    private UserRole userRole;

    // ✅ Explicit constructor for Lombok Builder that ignores the 'id' field
    @Builder
    public UserRoleMapping(UserInfo userInfo, UserRole userRole) {
        this.userInfo = userInfo;
        this.userRole = userRole;
    }
}
