package com.app.dasher.services;

import com.app.dasher.models.common.PersonalInfo;
import com.app.dasher.models.user.OtpRequestDto;
import com.app.dasher.models.user.UserPreferencesDto;
import org.springframework.http.ResponseEntity;

/**
 * @author Paly
 * @version 1.0
 * @date 03/11/22 3:38 am
 * @company NextUp
 */
public interface UserInfoService {
  ResponseEntity<Object> createUser(PersonalInfo personalInfo);

  Object generateOtp(OtpRequestDto otpRequestDto, String userId);

  Object confirmOtp(String userId, String otp);

  Object updatePreferences(UserPreferencesDto userPreferencesDto, String userId);
}
