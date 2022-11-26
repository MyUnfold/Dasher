package com.app.dasher.controllers.admin;

import com.app.dasher.models.ResponseDto;
import com.app.dasher.models.admin.AdminProperties;
import com.app.dasher.models.admin.PropertyType;
import com.app.dasher.models.coupon.Coupon;
import com.app.dasher.models.mood.Moods;
import com.app.dasher.services.AdminService;
import com.app.dasher.utils.Constant;
import java.util.List;
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
 * @date 03/11/22 4:38 am
 * @company NextUp
 */

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/v1/admin")
@RestController
public class AdminController {

  @Autowired
  AdminService adminService;

  @PostMapping("/property/create")
  public Mono<ResponseEntity<ResponseDto<Object>>> createProperty(@RequestBody List<AdminProperties> adminPropertiesList) {
    return Mono
        .just(adminService.createProperty(adminPropertiesList))
        .map(result -> new ResponseEntity<>(ResponseDto.success(result), HttpStatus.OK))
        .defaultIfEmpty(new ResponseEntity<>(ResponseDto.fail(Constant.BAD_REQUEST, String.class), HttpStatus.BAD_REQUEST))
        .onErrorResume(
            throwable -> Mono.just(new ResponseEntity<>(ResponseDto.fail(throwable.getMessage(),
                String.class), HttpStatus.BAD_REQUEST)));
  }

  @PostMapping("/mood/create")
  public Mono<ResponseEntity<ResponseDto<Object>>> createMood(@RequestBody List<Moods> moodsList) {
    return Mono
        .just(adminService.createMood(moodsList))
        .map(result -> new ResponseEntity<>(ResponseDto.success(result), HttpStatus.OK))
        .defaultIfEmpty(new ResponseEntity<>(ResponseDto.fail(Constant.BAD_REQUEST, String.class), HttpStatus.BAD_REQUEST))
        .onErrorResume(
            throwable -> Mono.just(new ResponseEntity<>(ResponseDto.fail(throwable.getMessage(),
                String.class), HttpStatus.BAD_REQUEST)));
  }

  @PostMapping("/coupon/create")
  public Mono<ResponseEntity<ResponseDto<Object>>> createCoupon(@RequestBody List<Coupon> couponList) {
    return Mono
        .just(adminService.createCoupon(couponList))
        .map(result -> new ResponseEntity<>(ResponseDto.success(result), HttpStatus.OK))
        .defaultIfEmpty(new ResponseEntity<>(ResponseDto.fail(Constant.BAD_REQUEST, String.class), HttpStatus.BAD_REQUEST))
        .onErrorResume(
            throwable -> Mono.just(new ResponseEntity<>(ResponseDto.fail(throwable.getMessage(),
                String.class), HttpStatus.BAD_REQUEST)));
  }

  @GetMapping("/property/create/{type}")
  public Mono<ResponseEntity<ResponseDto<Object>>> getPropertyBasedUponFilter(@PathVariable PropertyType type, @RequestParam(value = "search", required = false) String keyword) {
    return Mono
        .just(adminService.getPropertyBasedUponFilter(type, keyword))
        .map(result -> new ResponseEntity<>(ResponseDto.success(result), HttpStatus.OK))
        .defaultIfEmpty(new ResponseEntity<>(ResponseDto.fail(Constant.BAD_REQUEST, String.class), HttpStatus.BAD_REQUEST))
        .onErrorResume(
            throwable -> Mono.just(new ResponseEntity<>(ResponseDto.fail(throwable.getMessage(),
                String.class), HttpStatus.BAD_REQUEST)));
  }

}
