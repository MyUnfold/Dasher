package com.app.dasher.models.Resturant.menu;

import com.app.dasher.models.Resturant.Review.Review;
import com.app.dasher.models.Resturant.ServiceType;
import java.util.List;

/**
 * @author Paly
 * @version 1.0
 * @date 24/11/22 5:50 pm
 * @company NextUp
 */
public class MenuItems {

  private String id;
  private String name;
  private List<String> imageUrl;
  private List<String> tags;
  private double price;
  private FoodCategory category;
  private String description;

  private String shortDescription;
  private List<String> ingredients;
  private boolean isCustomizable;
  private ServiceType serviceType;

  private Review foodReview;

  private List<Customization> customizations;

  private boolean isVeg;

  public boolean isVeg() {
    return isVeg;
  }

  public void setVeg(boolean veg) {
    isVeg = veg;
  }

  public List<String> getImageUrl() {
    return imageUrl;
  }

  public void setImageUrl(List<String> imageUrl) {
    this.imageUrl = imageUrl;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public List<Customization> getCustomizations() {
    return customizations;
  }

  public void setCustomizations(
      List<Customization> customizations) {
    this.customizations = customizations;
  }

  public Review getFoodReview() {
    return foodReview;
  }

  public void setFoodReview(Review foodReview) {
    this.foodReview = foodReview;
  }

  public String getShortDescription() {
    return shortDescription;
  }

  public void setShortDescription(String shortDescription) {
    this.shortDescription = shortDescription;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public List<String> getTags() {
    return tags;
  }

  public void setTags(List<String> tags) {
    this.tags = tags;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  public FoodCategory getCategory() {
    return category;
  }

  public void setCategory(FoodCategory category) {
    this.category = category;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public List<String> getIngredients() {
    return ingredients;
  }

  public void setIngredients(List<String> ingredients) {
    this.ingredients = ingredients;
  }

  public boolean isCustomizable() {
    return isCustomizable;
  }

  public void setCustomizable(boolean customizable) {
    isCustomizable = customizable;
  }

  public ServiceType getServiceType() {
    return serviceType;
  }

  public void setServiceType(ServiceType serviceType) {
    this.serviceType = serviceType;
  }
}
