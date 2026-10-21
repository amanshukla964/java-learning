package org.example.controller;

import org.example.request.RestaurantRequestDTO;
import org.example.response.RestaurantResponseDTO;
import org.example.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/restaurant/v1")
public class RestaurantController {

    @Autowired
    private RestaurantService restaurantService;


    // =========================================================
    // CREATE RESTAURANT
    // =========================================================

    @PostMapping
    public ResponseEntity<RestaurantResponseDTO> createRestaurant(
            @RequestBody RestaurantRequestDTO request,
            Authentication authentication) {

        RestaurantResponseDTO response =
                restaurantService.createRestaurant(
                        request,
                        authentication.getName()
                );

        return new ResponseEntity<>(
                response,
                HttpStatus.CREATED
        );
    }


    // =========================================================
    // GET MY RESTAURANTS
    // =========================================================

    @GetMapping
    public ResponseEntity<List<RestaurantResponseDTO>> getMyRestaurants(
            Authentication authentication) {

        List<RestaurantResponseDTO> restaurants =
                restaurantService.getMyRestaurants(
                        authentication.getName()
                );

        return new ResponseEntity<>(
                restaurants,
                HttpStatus.OK
        );
    }


    // =========================================================
    // GET RESTAURANT BY ID
    // =========================================================

    @GetMapping("/{restaurantId}")
    public ResponseEntity<RestaurantResponseDTO> getRestaurantById(
            @PathVariable("restaurantId") Long restaurantId,
            Authentication authentication) {

        RestaurantResponseDTO response =
                restaurantService.getRestaurantById(
                        restaurantId,
                        authentication.getName()
                );

        return new ResponseEntity<>(
                response,
                HttpStatus.OK
        );
    }


    // =========================================================
    // UPDATE RESTAURANT
    // =========================================================

    @PutMapping("/{restaurantId}")
    public ResponseEntity<RestaurantResponseDTO> updateRestaurant(
            @PathVariable("restaurantId")
            Long restaurantId,
            @RequestBody RestaurantRequestDTO request,
            Authentication authentication) {

        RestaurantResponseDTO response =
                restaurantService.updateRestaurant(
                        restaurantId,
                        request,
                        authentication.getName()
                );

        return new ResponseEntity<>(
                response,
                HttpStatus.OK
        );
    }


    // =========================================================
    // DELETE RESTAURANT
    // =========================================================

    @DeleteMapping("/{restaurantId}")
    public ResponseEntity<String> deleteRestaurant(
            @PathVariable("restaurantId") Long restaurantId,
            Authentication authentication) {

        restaurantService.deleteRestaurant(
                restaurantId,
                authentication.getName()
        );

        return new ResponseEntity<>(
                "Restaurant deleted successfully",
                HttpStatus.OK
        );
    }


    // =========================================================
    // ACTIVATE RESTAURANT
    // =========================================================

    @PatchMapping("/{restaurantId}/activate")
    public ResponseEntity<RestaurantResponseDTO> activateRestaurant(
            @PathVariable("restaurantId") Long restaurantId,
            Authentication authentication) {

        RestaurantResponseDTO response =
                restaurantService.activateRestaurant(
                        restaurantId,
                        authentication.getName()
                );

        return new ResponseEntity<>(
                response,
                HttpStatus.OK
        );
    }


    // =========================================================
    // DEACTIVATE RESTAURANT
    // =========================================================

    @PatchMapping("/{restaurantId}/deactivate")
    public ResponseEntity<RestaurantResponseDTO> deactivateRestaurant(
            @PathVariable("restaurantId") Long restaurantId,
            Authentication authentication) {

        RestaurantResponseDTO response =
                restaurantService.deactivateRestaurant(
                        restaurantId,
                        authentication.getName()
                );

        return new ResponseEntity<>(
                response,
                HttpStatus.OK
        );
    }
}
