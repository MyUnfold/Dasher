package com.app.dasher.models.user;

import com.app.dasher.models.admin.AdminProperties;
import java.util.List;

/**
 * @author Paly
 * @version 1.0
 * @date 03/11/22 12:38 pm
 * @company NextUp
 */
public class UserPreferencesDto {
  private List<AdminProperties> interestsList;
  private List<AdminProperties> allergiesList;

  public List<AdminProperties> getInterestsList() {
    return interestsList;
  }

  public void setInterestsList(List<AdminProperties> interestsList) {
    this.interestsList = interestsList;
  }

  public List<AdminProperties> getAllergiesList() {
    return allergiesList;
  }

  public void setAllergiesList(List<AdminProperties> allergiesList) {
    this.allergiesList = allergiesList;
  }
}
