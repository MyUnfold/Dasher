package com.app.dasher.models.common;

import java.util.List;
import javax.validation.constraints.NotNull;

/**
 * @author Paly
 * @version 1.0
 * @date 03/11/22 3:37 am
 * @company NextUp
 */
public class PersonalInfo {

  List<Role> roles;
  private String fullName;
  @NotNull
  private String email;
  private String profilePictureURL;
  private String contactNumber;
  private boolean isOtpVerified;
  private String firebaseAuthTokenId;
  private String firebaseNotificationId;
  /*
      GOOGLE
      APPLE
      FACEBOOK
      EMAIL
   */
  private String loginWith;
  private boolean isPushNotificationEnabled;

  public boolean isOtpVerified() {
    return isOtpVerified;
  }

  public void setOtpVerified(boolean otpVerified) {
    isOtpVerified = otpVerified;
  }

  public List<Role> getRoles() {
    return roles;
  }

  public void setRoles(List<Role> roles) {
    this.roles = roles;
  }

  public String getFullName() {
    return fullName;
  }

  public void setFullName(String fullName) {
    this.fullName = fullName;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getProfilePictureURL() {
    return profilePictureURL;
  }

  public void setProfilePictureURL(String profilePictureURL) {
    this.profilePictureURL = profilePictureURL;
  }

  public String getContactNumber() {
    return contactNumber;
  }

  public void setContactNumber(String contactNumber) {
    this.contactNumber = contactNumber;
  }

  public String getFirebaseAuthTokenId() {
    return firebaseAuthTokenId;
  }

  public void setFirebaseAuthTokenId(String firebaseAuthTokenId) {
    this.firebaseAuthTokenId = firebaseAuthTokenId;
  }

  public String getFirebaseNotificationId() {
    return firebaseNotificationId;
  }

  public void setFirebaseNotificationId(String firebaseNotificationId) {
    this.firebaseNotificationId = firebaseNotificationId;
  }

  public String getLoginWith() {
    return loginWith;
  }

  public void setLoginWith(String loginWith) {
    this.loginWith = loginWith;
  }

  public boolean isPushNotificationEnabled() {
    return isPushNotificationEnabled;
  }

  public void setPushNotificationEnabled(boolean pushNotificationEnabled) {
    isPushNotificationEnabled = pushNotificationEnabled;
  }
}
