package org.example.service;

import org.example.entities.Restaurant;
import org.example.entities.UserInfo;
import org.example.repository.RestaurantRepository;
import org.example.repository.UserRepository;
import org.example.request.RestaurantRequestDTO;
import org.example.response.RestaurantResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantService {

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Autowired
    private UserRepository userRepository;


    // =========================================================
    // CREATE RESTAURANT
    // =========================================================

    public RestaurantResponseDTO createRestaurant(
            RestaurantRequestDTO request,
            String username) {

        UserInfo user = userRepository.findByUsername(username);

        if (user == null) {
            throw new RuntimeException("User not found");
        }

        Restaurant restaurant = Restaurant.builder()
                .owner(user)
                .name(request.getName())
                .description(request.getDescription())
                .phone(request.getPhone())
                .email(request.getEmail())
                .addressLine1(request.getAddressLine1())
                .addressLine2(request.getAddressLine2())
                .city(request.getCity())
                .state(request.getState())
                .pincode(request.getPincode())
                .country(request.getCountry())
                .logoUrl(request.getLogoUrl())
                .openingTime(request.getOpeningTime())
                .closingTime(request.getClosingTime())
                .active(true)
                .build();

        Restaurant savedRestaurant =
                restaurantRepository.save(restaurant);

        return convertToResponse(savedRestaurant);
    }


    // =========================================================
    // GET MY RESTAURANTS
    // =========================================================

    public List<RestaurantResponseDTO> getMyRestaurants(
            String username) {

        List<Restaurant> restaurants =
                restaurantRepository.findByOwnerUsername(username);

        return restaurants.stream()
                .map(this::convertToResponse)
                .toList();
    }


    // =========================================================
    // GET RESTAURANT BY ID
    // =========================================================

    public RestaurantResponseDTO getRestaurantById(
            Long restaurantId,
            String username) {

        Restaurant restaurant =
                restaurantRepository
                        .findByRestaurantIdAndOwnerUsername(
                                restaurantId,
                                username
                        )
                        .orElseThrow(() ->
                                new RuntimeException(
                                        "Restaurant not found"
                                ));

        return convertToResponse(restaurant);
    }


    // =========================================================
    // UPDATE RESTAURANT
    // =========================================================

    public RestaurantResponseDTO updateRestaurant(
            Long restaurantId,
            RestaurantRequestDTO request,
            String username) {

        Restaurant restaurant =
                restaurantRepository
                        .findByRestaurantIdAndOwnerUsername(
                                restaurantId,
                                username
                        )
                        .orElseThrow(() ->
                                new RuntimeException(
                                        "Restaurant not found"
                                ));

        restaurant.setName(request.getName());
        restaurant.setDescription(request.getDescription());
        restaurant.setPhone(request.getPhone());
        restaurant.setEmail(request.getEmail());

        restaurant.setAddressLine1(
                request.getAddressLine1()
        );

        restaurant.setAddressLine2(
                request.getAddressLine2()
        );

        restaurant.setCity(
                request.getCity()
        );

        restaurant.setState(
                request.getState()
        );

        restaurant.setPincode(
                request.getPincode()
        );

        restaurant.setCountry(
                request.getCountry()
        );

        restaurant.setLogoUrl(
                request.getLogoUrl()
        );

        restaurant.setOpeningTime(
                request.getOpeningTime()
        );

        restaurant.setClosingTime(
                request.getClosingTime()
        );

        Restaurant updatedRestaurant =
                restaurantRepository.save(restaurant);

        return convertToResponse(updatedRestaurant);
    }


    // =========================================================
    // DELETE RESTAURANT
    // =========================================================

    public void deleteRestaurant(
            Long restaurantId,
            String username) {

        Restaurant restaurant =
                restaurantRepository
                        .findByRestaurantIdAndOwnerUsername(
                                restaurantId,
                                username
                        )
                        .orElseThrow(() ->
                                new RuntimeException(
                                        "Restaurant not found"
                                ));

        restaurantRepository.delete(restaurant);
    }


    // =========================================================
    // ACTIVATE RESTAURANT
    // =========================================================

    public RestaurantResponseDTO activateRestaurant(
            Long restaurantId,
            String username) {

        Restaurant restaurant =
                restaurantRepository
                        .findByRestaurantIdAndOwnerUsername(
                                restaurantId,
                                username
                        )
                        .orElseThrow(() ->
                                new RuntimeException(
                                        "Restaurant not found"
                                ));

        restaurant.setActive(true);

        Restaurant updatedRestaurant =
                restaurantRepository.save(restaurant);

        return convertToResponse(updatedRestaurant);
    }


    // =========================================================
    // DEACTIVATE RESTAURANT
    // =========================================================

    public RestaurantResponseDTO deactivateRestaurant(
            Long restaurantId,
            String username) {

        Restaurant restaurant =
                restaurantRepository
                        .findByRestaurantIdAndOwnerUsername(
                                restaurantId,
                                username
                        )
                        .orElseThrow(() ->
                                new RuntimeException(
                                        "Restaurant not found"
                                ));

        restaurant.setActive(false);

        Restaurant updatedRestaurant =
                restaurantRepository.save(restaurant);

        return convertToResponse(updatedRestaurant);
    }


    // =========================================================
    // CONVERT ENTITY TO RESPONSE
    // =========================================================

    private RestaurantResponseDTO convertToResponse(
            Restaurant restaurant) {

        return RestaurantResponseDTO.builder()

                .restaurantId(
                        restaurant.getRestaurantId()
                )

                .ownerId(
                        restaurant.getOwner().getUserId()
                )

                .ownerUsername(
                        restaurant.getOwner().getUsername()
                )

                .name(
                        restaurant.getName()
                )

                .description(
                        restaurant.getDescription()
                )

                .phone(
                        restaurant.getPhone()
                )

                .email(
                        restaurant.getEmail()
                )

                .addressLine1(
                        restaurant.getAddressLine1()
                )

                .addressLine2(
                        restaurant.getAddressLine2()
                )

                .city(
                        restaurant.getCity()
                )

                .state(
                        restaurant.getState()
                )

                .pincode(
                        restaurant.getPincode()
                )

                .country(
                        restaurant.getCountry()
                )

                .logoUrl(
                        restaurant.getLogoUrl()
                )

                .openingTime(
                        restaurant.getOpeningTime()
                )

                .closingTime(
                        restaurant.getClosingTime()
                )

                .active(
                        restaurant.getActive()
                )

                .createdAt(
                        restaurant.getCreatedAt()
                )

                .updatedAt(
                        restaurant.getUpdatedAt()
                )

                .build();
    }
}
