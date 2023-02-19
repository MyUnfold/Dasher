package com.app.dasher.models.Resturant.dto;

import com.app.dasher.models.Resturant.ServiceType;

/**
 * @author Paly
 * @version 1.0
 * @date 24/11/22 8:30 pm
 * @company NextUp
 */
public class ListRestaurantConfigDto {

  private String name;
  private Double lat;
  private Double lng;
  private double distanceInKm;
  private double ratings;
  private ServiceType serviceType;
  private int currentTimeInHours;
  private String cuisine;

  public String getCuisine() {
    return cuisine;
  }

  public void setCuisine(String cuisine) {
    this.cuisine = cuisine;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Double getLat() {
    return lat;
  }

  public void setLat(Double lat) {
    this.lat = lat;
  }

  public Double getLng() {
    return lng;
  }

  public void setLng(Double lng) {
    this.lng = lng;
  }

  public double getDistanceInKm() {
    return distanceInKm;
  }

  public void setDistanceInKm(double distanceInKm) {
    this.distanceInKm = distanceInKm;
  }

  public double getRatings() {
    return ratings;
  }

  public void setRatings(double ratings) {
    this.ratings = ratings;
  }

  public ServiceType getServiceType() {
    return serviceType;
  }

  public void setServiceType(ServiceType serviceType) {
    this.serviceType = serviceType;
  }

  public int getCurrentTimeInHours() {
    return currentTimeInHours;
  }

  public void setCurrentTimeInHours(int currentTimeInHours) {
    this.currentTimeInHours = currentTimeInHours;
  }
}
