package com.app.dasher.models.Resturant.menu;

import java.util.List;

/**
 * @author Paly
 * @version 1.0
 * @date 24/11/22 8:26 pm
 * @company NextUp
 */
public class Customization {
  private String name;
  private double price;
  private List<SubCustomization> subCustomizationList;

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

  public List<SubCustomization> getSubCustomizationList() {
    return subCustomizationList;
  }

  public void setSubCustomizationList(
      List<SubCustomization> subCustomizationList) {
    this.subCustomizationList = subCustomizationList;
  }
}
