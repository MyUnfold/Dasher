package com.app.dasher.servicesImpl;

import com.app.dasher.models.common.PersonalInfo;
import com.app.dasher.models.user.OtpRequestDto;
import com.app.dasher.models.user.UserInfoResponseDto;
import com.app.dasher.models.user.UserPreferencesDto;
import com.app.dasher.models.user.UsersInfo;
import com.app.dasher.security.JwtTokenProvider;
import com.app.dasher.services.UserInfoService;
import com.app.dasher.utils.Constant;
import com.app.dasher.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * @author Paly
 * @version 1.0
 * @date 03/11/22 3:38 am
 * @company NextUp
 */

@Service
public class UserServiceImpl implements UserInfoService {


  @Autowired
  private MongoOperations mongoOperations;
  @Autowired
  private JwtTokenProvider jwtTokenProvider;
  @Autowired
  private PasswordEncoder passwordEncoder;


  @Override
  public ResponseEntity<Object> createUser(PersonalInfo personalInfo) {
    if (isRegistered(personalInfo)) {
      return retainUserInfo(personalInfo);
    } else {
      UsersInfo usersInfo = new UsersInfo();
      usersInfo.setId(Utils.generateId());
      usersInfo.setCreatedAt(Utils.getCurrentTime());
      usersInfo.setUpdatedAt(Utils.getCurrentTime());
      usersInfo.setPersonalInfo(personalInfo);

      if (personalInfo.getEmail() != null) {
        usersInfo.setEmail(personalInfo.getEmail());
      } else {
        usersInfo.setEmail(personalInfo.getFirebaseAuthTokenId() + "@nextup.com");
      }

      usersInfo.setPassword(passwordEncoder.encode(personalInfo.getFirebaseAuthTokenId()));
      UserInfoResponseDto userInfoResponseDto = new UserInfoResponseDto();
      userInfoResponseDto.setUserId(usersInfo.getId());
      userInfoResponseDto.setPersonalInfo(personalInfo);
      mongoOperations.save(usersInfo);

      String tokenHeader = jwtTokenProvider.createToken(personalInfo.getEmail(),
          personalInfo.getRoles(), false, false);
      return ResponseEntity.ok().header(Constant.TOKEN_HEADER, tokenHeader).body(usersInfo);
    }
  }

  private UsersInfo getUserInfoUsingID(String userId) {
    Query query = new Query(Criteria.where(Constant.COMMON_ID).is(userId));
    return mongoOperations.findOne(query, UsersInfo.class);
  }

  @Override
  public Object generateOtp(OtpRequestDto otpRequestDto, String userId) {
    UsersInfo usersInfo = getUserInfoUsingID(userId);
    usersInfo.setProposedOTP(Utils.generateOTP());
    usersInfo.getPersonalInfo().setContactNumber(otpRequestDto.getSourceInfo());
    usersInfo.getPersonalInfo().setFullName(otpRequestDto.getFullName());
    mongoOperations.save(usersInfo);
    return usersInfo.getProposedOTP();
  }

  @Override
  public Object confirmOtp(String userId, String otp) {
    UsersInfo usersInfo = getUserInfoUsingID(userId);
    if (usersInfo.getProposedOTP().equalsIgnoreCase(otp)) {
      usersInfo.getPersonalInfo().setOtpVerified(true);
      mongoOperations.save(usersInfo);
      return true;
    }
    return false;
  }

  @Override
  public Object updatePreferences(UserPreferencesDto userPreferencesDto, String userId) {
    UsersInfo usersInfo = getUserInfoUsingID(userId);
    usersInfo.setAllergies(userPreferencesDto.getAllergiesList());
    usersInfo.setInterests(userPreferencesDto.getInterestsList());
    usersInfo.setOnBoardingDone(true);
    return mongoOperations.save(usersInfo).isOnBoardingDone();
  }

  public boolean isRegistered(PersonalInfo personalInfo) {
    Query query = new Query(Criteria.where(Constant.USER_EMAIL).is(personalInfo.getEmail()));
    UsersInfo usersInfo = mongoOperations.findOne(query, UsersInfo.class);
    return null != usersInfo;
  }

  private ResponseEntity<Object> retainUserInfo(PersonalInfo personalInfo) {
    Query query = new Query(Criteria.where(Constant.USER_EMAIL).is(personalInfo.getEmail()));
    UsersInfo usersInfo = mongoOperations.findOne(query, UsersInfo.class);
    UserInfoResponseDto userInfoResponseDto = new UserInfoResponseDto();
    userInfoResponseDto.setUserId(usersInfo.getId());
    userInfoResponseDto.setId(usersInfo.getId());

    usersInfo.getPersonalInfo().setFirebaseNotificationId(personalInfo.getFirebaseNotificationId());
    usersInfo.getPersonalInfo().setFirebaseAuthTokenId(personalInfo.getFirebaseAuthTokenId());
    userInfoResponseDto.setPersonalInfo(usersInfo.getPersonalInfo());
    userInfoResponseDto.setOnBoardingDone(usersInfo.isOnBoardingDone());

    usersInfo.setPassword(passwordEncoder.encode(personalInfo.getFirebaseAuthTokenId()));
    String tokenHeader = jwtTokenProvider.createToken(personalInfo.getEmail(),
        personalInfo.getRoles(), false, false);
    mongoOperations.save(usersInfo);

    return ResponseEntity.ok().header(Constant.TOKEN_HEADER, tokenHeader).body(userInfoResponseDto);
  }
}
