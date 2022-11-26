package com.app.dasher.controllers;

import com.app.dasher.models.ResponseDto;
import com.app.dasher.models.Resturant.dto.ListRestaurantConfigDto;
import com.app.dasher.models.dashboard.RestaurantDetailFilterDto;
import com.app.dasher.services.HomeService;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 * @author Paly
 * @version 1.0
 * @date 26/11/22 7:04 pm
 * @company NextUp
 */

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/v1/home")
@RestController
public class HomeController {

  @Autowired
  HomeService homeService;

  @PostMapping("/dashboard/{userId}")
  public Mono<ResponseEntity<ResponseDto<Object>>> getUserDashboard(@PathVariable String userId,  @RequestBody ListRestaurantConfigDto listRestaurantConfigDto) {
    return Mono
        .just(homeService.getUserDashboard(listRestaurantConfigDto))
        .map(result -> new ResponseEntity<>(ResponseDto.success(result), HttpStatus.OK))
        .defaultIfEmpty(new ResponseEntity<>(ResponseDto.fail(Constant.BAD_REQUEST, String.class), HttpStatus.BAD_REQUEST))
        .onErrorResume(
            throwable -> Mono.just(new ResponseEntity<>(ResponseDto.fail(throwable.getMessage(),
                String.class), HttpStatus.BAD_REQUEST)));
  }

  @PostMapping("/restaurant/details")
  public Mono<ResponseEntity<ResponseDto<Object>>> getRestaurantDetails(@RequestBody
      RestaurantDetailFilterDto filterDto) {
    return Mono
        .just(homeService.getRestaurantDetails(filterDto))
        .map(result -> new ResponseEntity<>(ResponseDto.success(result), HttpStatus.OK))
        .defaultIfEmpty(new ResponseEntity<>(ResponseDto.fail(Constant.BAD_REQUEST, String.class), HttpStatus.BAD_REQUEST))
        .onErrorResume(
            throwable -> Mono.just(new ResponseEntity<>(ResponseDto.fail(throwable.getMessage(),
                String.class), HttpStatus.BAD_REQUEST)));
  }

}
