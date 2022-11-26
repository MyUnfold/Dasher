package com.app.dasher.models.dashboard;

import com.app.dasher.models.orders.OrderHistory;
import java.util.List;

/**
 * @author Paly
 * @version 1.0
 * @date 26/11/22 5:43 pm
 * @company NextUp
 */
public class UserDashboardDto {
  private List<OrderHistory> orders;
  private List<ListMoods> moodsList;
  private List<RestaurantInfoDto> recommendation;
  private List<RestaurantInfoDto> mustTry;
  private List<ListCoupons> couponList;

  public List<OrderHistory> getOrders() {
    return orders;
  }

  public void setOrders(List<OrderHistory> orders) {
    this.orders = orders;
  }


  public List<RestaurantInfoDto> getRecommendation() {
    return recommendation;
  }

  public void setRecommendation(
      List<RestaurantInfoDto> recommendation) {
    this.recommendation = recommendation;
  }

  public List<RestaurantInfoDto> getMustTry() {
    return mustTry;
  }

  public void setMustTry(List<RestaurantInfoDto> mustTry) {
    this.mustTry = mustTry;
  }

  public List<ListMoods> getMoodsList() {
    return moodsList;
  }

  public void setMoodsList(List<ListMoods> moodsList) {
    this.moodsList = moodsList;
  }

  public List<ListCoupons> getCouponList() {
    return couponList;
  }

  public void setCouponList(List<ListCoupons> couponList) {
    this.couponList = couponList;
  }
}
