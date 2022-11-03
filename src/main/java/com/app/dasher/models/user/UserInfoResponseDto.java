package com.app.dasher.models.user;

import com.app.dasher.models.common.PersonalInfo;

/**
 * @author Paly
 * @version 1.0
 * @date 03/11/22 3:48 am
 * @company NextUp
 */
public class UserInfoResponseDto {

  private String id;
  private String userId;
  private PersonalInfo personalInfo;
  private boolean isOnBoardingDone;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }

  public PersonalInfo getPersonalInfo() {
    return personalInfo;
  }

  public void setPersonalInfo(PersonalInfo personalInfo) {
    this.personalInfo = personalInfo;
  }

  public boolean isOnBoardingDone() {
    return isOnBoardingDone;
  }

  public void setOnBoardingDone(boolean onBoardingDone) {
    isOnBoardingDone = onBoardingDone;
  }
}
