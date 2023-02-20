package com.app.dasher.models.Resturant.dto;

import com.app.dasher.models.Resturant.Restaurant;

/**
 * @author Paly
 * @version 1.0
 * @date 18/01/23 6:04 PM
 * @company NextUp
 */
public class RestaurantDto extends Restaurant {

  private int openingHours;
  private int closingHours;

  public int getOpeningHours() {
    return openingHours;
  }

  public void setOpeningHours(int openingHours) {
    this.openingHours = openingHours;
  }

  public int getClosingHours() {
    return closingHours;
  }

  public void setClosingHours(int closingHours) {
    this.closingHours = closingHours;
  }
}
