package com.app.dasher.controllers;

import com.app.dasher.models.ResponseDto;
import com.app.dasher.models.Resturant.Restaurants;
import com.app.dasher.models.Resturant.dto.ListRestaurantConfigDto;
import com.app.dasher.models.Resturant.menu.MenuItems;
import com.app.dasher.models.user.OtpRequestDto;
import com.app.dasher.services.RestaurantService;
import com.app.dasher.utils.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 * @author Paly
 * @version 1.0
 * @date 24/11/22 8:28 pm
 * @company NextUp
 */

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/v1/restaurant")
@RestController
public class RestaurantController {

  @Autowired
  RestaurantService restaurantService;

  @PostMapping("/create")
  public Mono<ResponseEntity<ResponseDto<Object>>> createRestaurant(@RequestBody Restaurants restaurants) {
    return Mono
        .just(restaurantService.createRestaurant(restaurants))
        .map(result -> new ResponseEntity<>(ResponseDto.success(result), HttpStatus.OK))
        .defaultIfEmpty(new ResponseEntity<>(ResponseDto.fail(Constant.BAD_REQUEST, String.class), HttpStatus.BAD_REQUEST))
        .onErrorResume(
            throwable -> Mono.just(new ResponseEntity<>(ResponseDto.fail(throwable.getMessage(),
                String.class), HttpStatus.BAD_REQUEST)));
  }

  @GetMapping("/detail/{id}")
  public Mono<ResponseEntity<ResponseDto<Object>>> getRestaurantDetails(@PathVariable String id) {
    return Mono
        .just(restaurantService.getRestaurantDetails(id))
        .map(result -> new ResponseEntity<>(ResponseDto.success(result), HttpStatus.OK))
        .defaultIfEmpty(new ResponseEntity<>(ResponseDto.fail(Constant.BAD_REQUEST, String.class), HttpStatus.BAD_REQUEST))
        .onErrorResume(
            throwable -> Mono.just(new ResponseEntity<>(ResponseDto.fail(throwable.getMessage(),
                String.class), HttpStatus.BAD_REQUEST)));
  }

  @PostMapping("/list")
  public Mono<ResponseEntity<ResponseDto<Object>>> listRestaurantBasedUponConfig(@RequestBody ListRestaurantConfigDto listRestaurantConfigDto) {
    return Mono
        .just(restaurantService.listRestaurantBasedUponConfig(listRestaurantConfigDto))
        .map(result -> new ResponseEntity<>(ResponseDto.success(result), HttpStatus.OK))
        .defaultIfEmpty(new ResponseEntity<>(ResponseDto.fail(Constant.BAD_REQUEST, String.class), HttpStatus.BAD_REQUEST))
        .onErrorResume(
            throwable -> Mono.just(new ResponseEntity<>(ResponseDto.fail(throwable.getMessage(),
                String.class), HttpStatus.BAD_REQUEST)));
  }

  @PostMapping("/add/menu/{restaurantId}")
  public Mono<ResponseEntity<ResponseDto<Object>>> createMenuItemForRestaurant(@PathVariable String restaurantId, @RequestBody MenuItems menuItems) {
    return Mono
        .just(restaurantService.createMenuItemForRestaurant(restaurantId, menuItems))
        .map(result -> new ResponseEntity<>(ResponseDto.success(result), HttpStatus.OK))
        .defaultIfEmpty(new ResponseEntity<>(ResponseDto.fail(Constant.BAD_REQUEST, String.class), HttpStatus.BAD_REQUEST))
        .onErrorResume(
            throwable -> Mono.just(new ResponseEntity<>(ResponseDto.fail(throwable.getMessage(),
                String.class), HttpStatus.BAD_REQUEST)));
  }

  @GetMapping("/detail/menu/{id}/{menuId}")
  public Mono<ResponseEntity<ResponseDto<Object>>> getRestaurantMenuCustomizableList(@PathVariable String id, @PathVariable String menuId) {
    return Mono
        .just(restaurantService.getRestaurantMenuCustomizableList(id, menuId))
        .map(result -> new ResponseEntity<>(ResponseDto.success(result), HttpStatus.OK))
        .defaultIfEmpty(new ResponseEntity<>(ResponseDto.fail(Constant.BAD_REQUEST, String.class), HttpStatus.BAD_REQUEST))
        .onErrorResume(
            throwable -> Mono.just(new ResponseEntity<>(ResponseDto.fail(throwable.getMessage(),
                String.class), HttpStatus.BAD_REQUEST)));
  }

}
