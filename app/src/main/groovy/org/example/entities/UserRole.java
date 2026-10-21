package org.example.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(
        name = "user_role",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "name")
        }
)
public class UserRole {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="role_id")
    private  Long roleId;
    private  String name;
}
