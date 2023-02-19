package com.app.dasher.models.dashboard;

/**
 * @author Paly
 * @version 1.0
 * @date 26/11/22 8:51 pm
 * @company NextUp
 */
public class RestaurantDetailFilterDto {

  private String userId;
  private String restaurantId;
  private String menuSearch;

  public String getMenuSearch() {
    return menuSearch;
  }

  public void setMenuSearch(String menuSearch) {
    this.menuSearch = menuSearch;
  }

  public String getRestaurantId() {
    return restaurantId;
  }

  public void setRestaurantId(String restaurantId) {
    this.restaurantId = restaurantId;
  }

  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }


}
