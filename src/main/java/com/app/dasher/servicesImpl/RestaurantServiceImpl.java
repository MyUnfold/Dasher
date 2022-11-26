package com.app.dasher.servicesImpl;

import com.app.dasher.models.Resturant.Restaurants;
import com.app.dasher.models.Resturant.dto.ListRestaurantConfigDto;
import com.app.dasher.models.Resturant.menu.MenuItems;
import com.app.dasher.services.RestaurantService;
import com.app.dasher.utils.Constant;
import com.app.dasher.utils.Utils;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.IntStream;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.geo.Circle;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.Metrics;
import org.springframework.data.geo.Point;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

/**
 * @author Paly
 * @version 1.0
 * @date 24/11/22 8:36 pm
 * @company NextUp
 */

@Service
public class RestaurantServiceImpl implements RestaurantService {

  @Autowired
  MongoOperations mongoOperations;

  @Autowired
  MongoTemplate mongoTemplate;

  @Override
  public Object createRestaurant(Restaurants restaurantsDto) {
      Restaurants restaurantsDetails = new Restaurants();
      try {
        BeanUtils.copyProperties(restaurantsDetails, restaurantsDto);
      } catch (Exception e) {
        e.printStackTrace();
      }

    restaurantsDetails.setId(Utils.generateId());
    restaurantsDetails.setUpdatedAt(Utils.getCurrentTime());
    restaurantsDetails.setCreatedAt(Utils.getCurrentTime());
    restaurantsDetails.setActive(true);
    return mongoOperations.save(restaurantsDetails).getId();
  }

  @Override
  public Object getRestaurantDetails(String id) {
    Query query = new Query(Criteria.where(Constant.COMMON_ID).is(id));
    return mongoOperations.findOne(query, Restaurants.class);
  }

  @Override
  public Object listRestaurantBasedUponConfig(ListRestaurantConfigDto listRestaurantConfigDto) {
    Query query = new Query();

    if(null != listRestaurantConfigDto.getName()){
      query.addCriteria(Criteria.where("name").regex(Pattern.compile(listRestaurantConfigDto.getName(), Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE)));
    }

    if(null != listRestaurantConfigDto.getServiceType()){
      query.addCriteria(Criteria.where("serviceType").is(listRestaurantConfigDto.getServiceType()));
    }

    if(null != listRestaurantConfigDto.getCuisine()){
      query.addCriteria(Criteria.where("cuisine").is(listRestaurantConfigDto.getCuisine()));
    }

    if(null != listRestaurantConfigDto.getClosingHours() && null != listRestaurantConfigDto.getOpeningHours()){
      query.addCriteria(new Criteria().andOperator(
          Criteria.where("openingTime").gte(listRestaurantConfigDto.getOpeningHours()),
          Criteria.where("closingTime").lte(listRestaurantConfigDto.getClosingHours())
      ));
    }

    if(null != listRestaurantConfigDto.getRatings()){
      query.addCriteria(new Criteria().orOperator(
          Criteria.where("diningReview").gte(Double.parseDouble(listRestaurantConfigDto.getRatings())),
          Criteria.where("serviceReview").lte(Double.parseDouble(listRestaurantConfigDto.getRatings()))
      ));
    }

    if(listRestaurantConfigDto.getLng() != null && listRestaurantConfigDto.getLng() != null && listRestaurantConfigDto.getDistanceInKm() >0.0) {
      Circle myCircle = new Circle(new Point(listRestaurantConfigDto.getLng(),
          listRestaurantConfigDto.getLat()),
          new Distance(listRestaurantConfigDto.getDistanceInKm(), Metrics.KILOMETERS));
      query.addCriteria(Criteria.where("location").withinSphere(myCircle));
   }
    return mongoOperations.find(query, Restaurants.class);
  }

  @Override
  public Object getRestaurantMenuCustomizableList(String restaurantId, String menuId) {
    Restaurants restaurants = (Restaurants) getRestaurantDetails(restaurantId);

    int menuItemMatchedIndex = IntStream.range(0, restaurants.getMenuItemsList().size())
        .filter(index -> restaurants.getMenuItemsList().get(index).getId().equalsIgnoreCase(menuId))
        .findFirst()
        .getAsInt();

    return restaurants.getMenuItemsList().get(menuItemMatchedIndex).getCustomizations();
  }

  @Override
  public Object createMenuItemForRestaurant(String restaurantId, MenuItems menuItems) {
    Restaurants restaurants = (Restaurants) getRestaurantDetails(restaurantId);
    menuItems.setId(Utils.generateId());
    if(null != restaurants){
      if(null != restaurants.getMenuItemsList() && restaurants.getMenuItemsList().size()>0){
        List<MenuItems> existingMenuItemsList = new ArrayList<>();
        existingMenuItemsList.addAll(restaurants.getMenuItemsList());
        existingMenuItemsList.add(menuItems);
        restaurants.setMenuItemsList(existingMenuItemsList);
        mongoOperations.save(restaurants);
      } else {
        List<MenuItems> existingMenuItemsList = new ArrayList<>();
        existingMenuItemsList.add(menuItems);
        restaurants.setMenuItemsList(existingMenuItemsList);
        mongoOperations.save(restaurants);
      }
      return "Successfully Added";
    }
    else return "Restaurant not found";
  }

}
