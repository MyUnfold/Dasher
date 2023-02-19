package com.app.dasher.servicesImpl;

import com.app.dasher.models.admin.AdminProperties;
import com.app.dasher.models.admin.PropertyType;
import com.app.dasher.models.coupon.Coupon;
import com.app.dasher.models.mood.Moods;
import com.app.dasher.services.AdminService;
import com.app.dasher.utils.Constant;
import com.app.dasher.utils.Utils;
import java.util.List;
import java.util.regex.Pattern;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

/**
 * @author Paly
 * @version 1.0
 * @date 03/11/22 4:37 am
 * @company NextUp
 */

@Service
public class AdminServiceImpl implements AdminService {

  @Autowired
  MongoOperations mongoOperations;

  @Override
  public Object createProperty(List<AdminProperties> adminPropertiesList) {

    for (AdminProperties adminProperties : adminPropertiesList) {
      AdminProperties adminPropertiesDetails = new AdminProperties();
      try {
        BeanUtils.copyProperties(adminPropertiesDetails, adminProperties);
      } catch (Exception e) {
        e.printStackTrace();
      }

      adminPropertiesDetails.setId(Utils.generateId());
      adminPropertiesDetails.setUpdatedAt(Utils.getCurrentTime());
      adminPropertiesDetails.setCreatedAt(Utils.getCurrentTime());
      adminPropertiesDetails.setActive(true);
      mongoOperations.save(adminPropertiesDetails);
    }
    return adminPropertiesList;
  }

  @Override
  public Object createMood(List<Moods> moodsList) {
    for (Moods moodDto : moodsList) {
      Moods moodDetails = new Moods();
      try {
        BeanUtils.copyProperties(moodDetails, moodDto);
      } catch (Exception e) {
        e.printStackTrace();
      }

      moodDetails.setId(Utils.generateId());
      moodDetails.setUpdatedAt(Utils.getCurrentTime());
      moodDetails.setCreatedAt(Utils.getCurrentTime());
      moodDetails.setActive(true);
      mongoOperations.save(moodDetails);
    }
    return "Successfully Added";
  }

  @Override
  public Object createCoupon(List<Coupon> couponList) {
    for (Coupon couponDto : couponList) {
      Coupon couponDetails = new Coupon();
      try {
        BeanUtils.copyProperties(couponDetails, couponDto);
      } catch (Exception e) {
        e.printStackTrace();
      }

      couponDetails.setId(Utils.generateId());
      couponDetails.setUpdatedAt(Utils.getCurrentTime());
      couponDetails.setCreatedAt(Utils.getCurrentTime());
      couponDetails.setActive(true);
      mongoOperations.save(couponDetails);
    }
    return "Successfully Added";
  }

  @Override
  public Object getPropertyBasedUponFilter(PropertyType propertyType, String keyword) {
    Query query = new Query();
    query.addCriteria(Criteria.where("property_type").is(propertyType));

    if (null != keyword) {
      query.addCriteria(Criteria.where("name")
          .regex(Pattern.compile(keyword, Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE)));
    }
    return mongoOperations.find(query, AdminProperties.class);
  }

  @Override
  public Object listOfMoods() {
    Query query = new Query();
    query.addCriteria(Criteria.where(Constant.COMMON_ACTIVE).is(true));
    return mongoOperations.find(query, Moods.class);
  }

  @Override
  public Object listOfCoupon() {
    Query query = new Query();
    query.addCriteria(Criteria.where(Constant.COMMON_ACTIVE).is(true));
    return mongoOperations.find(query, Coupon.class);
  }


}
