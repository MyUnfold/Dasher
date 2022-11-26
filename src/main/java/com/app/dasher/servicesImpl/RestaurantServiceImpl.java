package com.app.dasher.servicesImpl;

import com.app.dasher.models.Resturant.Ratings;
import com.app.dasher.models.Resturant.Restaurants;
import com.app.dasher.models.Resturant.Review.Review;
import com.app.dasher.models.Resturant.Review.dto.ReviewDto;
import com.app.dasher.models.Resturant.dto.ListRestaurantConfigDto;
import com.app.dasher.models.Resturant.menu.MenuItems;
import com.app.dasher.models.Resturant.menu.dto.MenuListDto;
import com.app.dasher.models.dashboard.MenuBriefInfoDto;
import com.app.dasher.models.dashboard.RestaurantDetailFilterDto;
import com.app.dasher.services.RestaurantService;
import com.app.dasher.utils.Constant;
import com.app.dasher.utils.Utils;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
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

  @Override
  public MenuListDto getMenuItemsBasedUponFilters(RestaurantDetailFilterDto filterDto) {
    Restaurants restaurants = (Restaurants) getRestaurantDetails(filterDto.getRestaurantId());
    List<MenuItems> menuItemsList = restaurants.getMenuItemsList();
    MenuListDto menuListDto = new MenuListDto();

    List<MenuBriefInfoDto> diningMenuList = new ArrayList<>();
    List<MenuBriefInfoDto> pickUpMenuList = new ArrayList<>();

    if(null != menuItemsList && menuItemsList.size()>0){
      for(MenuItems menuItems: menuItemsList){
          MenuBriefInfoDto menuBriefInfoDto  = new MenuBriefInfoDto();
          menuBriefInfoDto.setName(menuItems.getName());
          menuBriefInfoDto.setImageUrl(menuItems.getImageUrl());
          menuBriefInfoDto.setPrice(menuItems.getPrice());
          menuBriefInfoDto.setVeg(menuItems.isVeg());
          menuBriefInfoDto.setReview(ThreadLocalRandom.current().nextDouble(0.0, 10.0));
          menuBriefInfoDto.setSubList(menuItems.getShortDescription());
          menuBriefInfoDto.setCustomizable(menuItems.isCustomizable());
          menuBriefInfoDto.setId(menuItems.getId());
          diningMenuList.add(menuBriefInfoDto);
      }
    }

    pickUpMenuList.addAll(diningMenuList);
    menuListDto.setDiningMenuList(diningMenuList);
    menuListDto.setPickUpMenuList(pickUpMenuList);
    return menuListDto;

  }

  @Override
  public Object addReviewToRestaurants(String id, ReviewDto review) {
    Restaurants restaurants = (Restaurants) getRestaurantDetails(id);

    if(review.isDinning()){
      if(restaurants.getDiningReview() != null) {
        if (null != restaurants.getDiningReview().getReviewList() && restaurants.getDiningReview().getReviewList().size()>0){
          List<Review> reviewList = restaurants.getDiningReview().getReviewList();
          reviewList.add(review);
          restaurants.getDiningReview().setReviewList(reviewList);
          mongoOperations.save(restaurants);
        } else {
          List<Review> reviewList = new ArrayList<>();
          reviewList.add(review);
          restaurants.getDiningReview().setReviewList(reviewList);
          mongoOperations.save(restaurants);
        }
      } else {
        Ratings ratings = new Ratings();
        List<Review> reviewList = new ArrayList<>();
        reviewList.add(review);
        ratings.setReviewList(reviewList);
        restaurants.setDiningReview(ratings);
        mongoOperations.save(restaurants);
      }
    } else {
      if(restaurants.getServiceReview() != null) {
        if (null != restaurants.getServiceReview().getReviewList() && restaurants.getServiceReview().getReviewList().size()>0){
          List<Review> reviewList = restaurants.getServiceReview().getReviewList();
          reviewList.add(review);
          restaurants.getServiceReview().setReviewList(reviewList);
          mongoOperations.save(restaurants);
        } else {
          List<Review> reviewList = new ArrayList<>();
          reviewList.add(review);
          restaurants.getServiceReview().setReviewList(reviewList);
          mongoOperations.save(restaurants);
        }
      } else {
        Ratings ratings = new Ratings();
        List<Review> reviewList = new ArrayList<>();
        reviewList.add(review);
        ratings.setReviewList(reviewList);
        restaurants.setServiceReview(ratings);
        mongoOperations.save(restaurants);
      }
    }
    return "Successfully Added";
  }

  @Override
  public Object listReviewForRestaurant(String id, int page, int size) {
    Restaurants restaurants = (Restaurants) getRestaurantDetails(id);
    List<Review> reviewList = new ArrayList<>();

    if(null != restaurants.getDiningReview() && null != restaurants.getDiningReview().getReviewList() && restaurants.getDiningReview().getReviewList().size()>0) {
      reviewList.addAll(restaurants.getDiningReview().getReviewList());
    }

    if(null != restaurants.getServiceReview() && null != restaurants.getServiceReview().getReviewList() && restaurants.getServiceReview().getReviewList().size()>0) {
      reviewList.addAll(restaurants.getServiceReview().getReviewList());
    }
    return reviewList;
  }
}
