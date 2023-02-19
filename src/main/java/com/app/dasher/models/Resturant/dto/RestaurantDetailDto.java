package com.app.dasher.models.Resturant.dto;

import com.app.dasher.models.Resturant.menu.dto.MenuListDto;
import java.util.List;

/**
 * @author Paly
 * @version 1.0
 * @date 26/11/22 8:18 pm
 * @company NextUp
 */
public class RestaurantDetailDto {

  private String name;
  private String logoUrl;
  private String id;
  private ReviewerDto diningReview;
  private ReviewerDto serviceReview;
  private List<String> tags;
  private double lat;
  private double lng;
  private RestaurantViewMoreInfoDto restaurantViewMoreInfoDto;
  private MenuListDto menuItemsList;

  public MenuListDto getMenuItemsList() {
    return menuItemsList;
  }

  public void setMenuItemsList(MenuListDto menuItemsList) {
    this.menuItemsList = menuItemsList;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getLogoUrl() {
    return logoUrl;
  }

  public void setLogoUrl(String logoUrl) {
    this.logoUrl = logoUrl;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public ReviewerDto getDiningReview() {
    return diningReview;
  }

  public void setDiningReview(ReviewerDto diningReview) {
    this.diningReview = diningReview;
  }

  public ReviewerDto getServiceReview() {
    return serviceReview;
  }

  public void setServiceReview(ReviewerDto serviceReview) {
    this.serviceReview = serviceReview;
  }

  public List<String> getTags() {
    return tags;
  }

  public void setTags(List<String> tags) {
    this.tags = tags;
  }

  public double getLat() {
    return lat;
  }

  public void setLat(double lat) {
    this.lat = lat;
  }

  public double getLng() {
    return lng;
  }

  public void setLng(double lng) {
    this.lng = lng;
  }

  public RestaurantViewMoreInfoDto getRestaurantViewMoreInfoDto() {
    return restaurantViewMoreInfoDto;
  }

  public void setRestaurantViewMoreInfoDto(
      RestaurantViewMoreInfoDto restaurantViewMoreInfoDto) {
    this.restaurantViewMoreInfoDto = restaurantViewMoreInfoDto;
  }
}
