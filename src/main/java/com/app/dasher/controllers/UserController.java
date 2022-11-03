package com.app.dasher.controllers;

import com.app.dasher.models.ResponseDto;
import com.app.dasher.models.common.PersonalInfo;
import com.app.dasher.models.user.OtpRequestDto;
import com.app.dasher.models.user.UserPreferencesDto;
import com.app.dasher.services.UserInfoService;
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
 * @date 03/11/22 3:31 am
 * @company NextUp
 */

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/v1/user")
@RestController
public class UserController {

  @Autowired
  UserInfoService userInfoService;

  @PostMapping("/register")
  public ResponseEntity<Object> createUser(@RequestBody PersonalInfo personalInfo) {
    return userInfoService.createUser(personalInfo);
  }

  @PostMapping("/request/otp/{userId}")
  public Mono<ResponseEntity<ResponseDto<Object>>> requestOtp(@RequestBody OtpRequestDto otpRequestDto, @PathVariable String userId) {
    return Mono
        .just(userInfoService.generateOtp(otpRequestDto, userId))
        .map(result -> new ResponseEntity<>(ResponseDto.success(result), HttpStatus.OK))
        .defaultIfEmpty(new ResponseEntity<>(ResponseDto.fail(Constant.BAD_REQUEST, String.class), HttpStatus.BAD_REQUEST))
        .onErrorResume(
            throwable -> Mono.just(new ResponseEntity<>(ResponseDto.fail(throwable.getMessage(),
                String.class), HttpStatus.BAD_REQUEST)));
  }

  @GetMapping("/verify/otp/{userId}/{otpCode}")
  public Mono<ResponseEntity<ResponseDto<Object>>> confirmOtp(@PathVariable String userId, @PathVariable String otpCode) {
    return Mono
        .just(userInfoService.confirmOtp(userId, otpCode))
        .map(result -> new ResponseEntity<>(ResponseDto.success(result), HttpStatus.OK))
        .defaultIfEmpty(new ResponseEntity<>(ResponseDto.fail(Constant.BAD_REQUEST, String.class), HttpStatus.BAD_REQUEST))
        .onErrorResume(
            throwable -> Mono.just(new ResponseEntity<>(ResponseDto.fail(throwable.getMessage(),
                String.class), HttpStatus.BAD_REQUEST)));
  }

  @PostMapping("/update/preferences/{userId}")
  public Mono<ResponseEntity<ResponseDto<Object>>> updatePreferences(@RequestBody UserPreferencesDto userPreferencesDto, @PathVariable String userId) {
    return Mono
        .just(userInfoService.updatePreferences(userPreferencesDto, userId))
        .map(result -> new ResponseEntity<>(ResponseDto.success(result), HttpStatus.OK))
        .defaultIfEmpty(new ResponseEntity<>(ResponseDto.fail(Constant.BAD_REQUEST, String.class), HttpStatus.BAD_REQUEST))
        .onErrorResume(
            throwable -> Mono.just(new ResponseEntity<>(ResponseDto.fail(throwable.getMessage(),
                String.class), HttpStatus.BAD_REQUEST)));
  }
}
