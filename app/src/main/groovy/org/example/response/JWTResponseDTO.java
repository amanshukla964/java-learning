package org.example.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class JWTResponseDTO {

    private String accessToken;

    private String token;

    private Long userId;

    private String username;

    private Set<String> roles;
}
