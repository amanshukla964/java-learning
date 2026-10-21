package org.example.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.LocalTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RestaurantResponseDTO {

    private Long restaurantId;

    private Long ownerId;

    private String ownerUsername;

    private String name;

    private String description;

    private String phone;

    private String email;

    private String addressLine1;

    private String addressLine2;

    private String city;

    private String state;

    private String pincode;

    private String country;

    private String logoUrl;

    private LocalTime openingTime;

    private LocalTime closingTime;

    private Boolean active;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}
