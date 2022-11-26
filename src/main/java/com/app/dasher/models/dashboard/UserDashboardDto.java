package com.app.dasher.models.dashboard;

import com.app.dasher.models.coupon.Coupon;
import com.app.dasher.models.mood.Moods;
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
  private List<Moods> moodsList;
  private List<RestaurantInfoDto> recommendation;
  private List<RestaurantInfoDto> mustTry;
  private List<Coupon> couponList;

  public List<OrderHistory> getOrders() {
    return orders;
  }

  public void setOrders(List<OrderHistory> orders) {
    this.orders = orders;
  }

  public List<Moods> getMoodsList() {
    return moodsList;
  }

  public void setMoodsList(List<Moods> moodsList) {
    this.moodsList = moodsList;
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

  public List<Coupon> getCouponList() {
    return couponList;
  }

  public void setCouponList(List<Coupon> couponList) {
    this.couponList = couponList;
  }
}
