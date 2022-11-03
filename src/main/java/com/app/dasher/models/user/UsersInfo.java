package com.app.dasher.models.user;

import com.app.dasher.models.admin.AdminProperties;
import com.app.dasher.models.common.BaseModel;
import com.app.dasher.models.common.GeoLocation;
import com.app.dasher.models.common.PersonalInfo;
import com.app.dasher.models.common.Role;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.firebase.database.annotations.NotNull;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author Paly
 * @version 1.0
 * @date 03/11/22 3:33 am
 * @company NextUp
 */

@Getter
@Setter
@Document(collection = "tbl_user")
public class UsersInfo extends BaseModel {

  private String email;
  private String password;

  private String proposedOTP;

  @JsonIgnore
  @Id
  private ObjectId objectId;
  private String id;
  private List<Role> roles;

  private PersonalInfo personalInfo;
  @NotNull
  private GeoLocation currentLocation;
  private boolean isOnBoardingDone;

  private List<AdminProperties> interests;
  private List<AdminProperties> allergies;

  public List<AdminProperties> getInterests() {
    return interests;
  }

  public void setInterests(List<AdminProperties> interests) {
    this.interests = interests;
  }

  public List<AdminProperties> getAllergies() {
    return allergies;
  }

  public void setAllergies(List<AdminProperties> allergies) {
    this.allergies = allergies;
  }

  public String getProposedOTP() {
    return proposedOTP;
  }

  public void setProposedOTP(String proposedOTP) {
    this.proposedOTP = proposedOTP;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public ObjectId getObjectId() {
    return objectId;
  }

  public void setObjectId(ObjectId objectId) {
    this.objectId = objectId;
  }


  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public List<Role> getRoles() {
    return roles;
  }

  public void setRoles(List<Role> roles) {
    this.roles = roles;
  }

  public PersonalInfo getPersonalInfo() {
    return personalInfo;
  }

  public void setPersonalInfo(PersonalInfo personalInfo) {
    this.personalInfo = personalInfo;
  }

  public GeoLocation getCurrentLocation() {
    return currentLocation;
  }

  public void setCurrentLocation(GeoLocation currentLocation) {
    this.currentLocation = currentLocation;
  }

  public boolean isOnBoardingDone() {
    return isOnBoardingDone;
  }

  public void setOnBoardingDone(boolean onBoardingDone) {
    isOnBoardingDone = onBoardingDone;
  }
}
