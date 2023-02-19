package com.app.dasher.models.Resturant.dto;

import com.app.dasher.models.Resturant.Restaurant;

/**
 * @author Paly
 * @version 1.0
 * @date 18/01/23 6:04 PM
 * @company NextUp
 */
public class RestaurantDto extends Restaurant {

  private String openingHours;
  private String closingHours;

  public String getOpeningHours() {
    return openingHours;
  }

  public void setOpeningHours(String openingHours) {
    this.openingHours = openingHours;
  }

  public String getClosingHours() {
    return closingHours;
  }

  public void setClosingHours(String closingHours) {
    this.closingHours = closingHours;
  }
}
