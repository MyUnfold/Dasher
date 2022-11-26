package com.app.dasher.models.dashboard;

import java.util.List;

/**
 * @author Paly
 * @version 1.0
 * @date 26/11/22 8:55 pm
 * @company NextUp
 */
public class MenuBriefInfoDto {
  private String name;
  private List<String> imageUrl;
  private double price;
  private double review;
  private String id;
  private String subList;
  private boolean isVeg;

  private boolean isCustomizable;

  public boolean isCustomizable() {
    return isCustomizable;
  }

  public void setCustomizable(boolean customizable) {
    isCustomizable = customizable;
  }

  public List<String> getImageUrl() {
    return imageUrl;
  }

  public void setImageUrl(List<String> imageUrl) {
    this.imageUrl = imageUrl;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  public double getReview() {
    return review;
  }

  public void setReview(double review) {
    this.review = review;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getSubList() {
    return subList;
  }

  public void setSubList(String subList) {
    this.subList = subList;
  }

  public boolean isVeg() {
    return isVeg;
  }

  public void setVeg(boolean veg) {
    isVeg = veg;
  }
}
