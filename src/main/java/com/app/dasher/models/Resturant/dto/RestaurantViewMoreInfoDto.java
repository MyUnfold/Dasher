package com.app.dasher.models.Resturant.dto;

import com.app.dasher.models.Resturant.menu.dto.MenuListDto;
import com.app.dasher.models.dashboard.MenuBriefInfoDto;
import java.util.List;

/**
 * @author Paly
 * @version 1.0
 * @date 26/11/22 8:21 pm
 * @company NextUp
 */
public class RestaurantViewMoreInfoDto {
  private List<String> imageUrl;
  private String logoUrl;
  private String name;
  private ReviewerDto diningReview;
  private ReviewerDto serviceReview;
  private String customAddress;
  private String metaLine;
  private double lat;
  private double lng;

  private MenuListDto trendingMenu;

  public MenuListDto getTrendingMenu() {
    return trendingMenu;
  }

  public void setTrendingMenu(MenuListDto trendingMenu) {
    this.trendingMenu = trendingMenu;
  }

  public List<String> getImageUrl() {
    return imageUrl;
  }

  public void setImageUrl(List<String> imageUrl) {
    this.imageUrl = imageUrl;
  }

  public String getLogoUrl() {
    return logoUrl;
  }

  public void setLogoUrl(String logoUrl) {
    this.logoUrl = logoUrl;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
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

  public String getCustomAddress() {
    return customAddress;
  }

  public void setCustomAddress(String customAddress) {
    this.customAddress = customAddress;
  }

  public String getMetaLine() {
    return metaLine;
  }

  public void setMetaLine(String metaLine) {
    this.metaLine = metaLine;
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
}
