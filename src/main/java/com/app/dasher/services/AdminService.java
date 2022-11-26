package com.app.dasher.services;

import com.app.dasher.models.admin.AdminProperties;
import com.app.dasher.models.admin.PropertyType;
import com.app.dasher.models.coupon.Coupon;
import com.app.dasher.models.mood.Moods;
import java.util.List;

/**
 * @author Paly
 * @version 1.0
 * @date 03/11/22 4:37 am
 * @company NextUp
 */
public interface AdminService {

  Object createProperty(List<AdminProperties> adminPropertiesList);
  Object createMood(List<Moods> moodsList);
  Object createCoupon(List<Coupon> couponList);
  Object getPropertyBasedUponFilter(PropertyType propertyType, String keyword);
  Object listOfMoods();
  Object listOfCoupon();

}
