package com.app.dasher.models.dashboard;

import java.util.List;

/**
 * @author Paly
 * @version 1.0
 * @date 26/11/22 6:09 pm
 * @company NextUp
 */
public class RestaurantInfoDto {
  private String name;
  private String imageUrl;
  private boolean isOpen;
  private List<String> cuisine;

  private double ratings;
  private double deliveryTime;

  public double getRatings() {
    return ratings;
  }

  public void setRatings(double ratings) {
    this.ratings = ratings;
  }

  public double getDeliveryTime() {
    return deliveryTime;
  }

  public void setDeliveryTime(double deliveryTime) {
    this.deliveryTime = deliveryTime;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getImageUrl() {
    return imageUrl;
  }

  public void setImageUrl(String imageUrl) {
    this.imageUrl = imageUrl;
  }

  public boolean isOpen() {
    return isOpen;
  }

  public void setOpen(boolean open) {
    isOpen = open;
  }

  public List<String> getCuisine() {
    return cuisine;
  }

  public void setCuisine(List<String> cuisine) {
    this.cuisine = cuisine;
  }
}
