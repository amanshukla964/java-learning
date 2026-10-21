package org.example.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;
import org.example.entities.UserInfo;

import java.util.Set;


@Data
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class UserInfoDto extends UserInfo {
    private  String username;

    private String lastName;

    private Long phoneNumber;

    private  String email;

    private Set<String> userRoles;
}
