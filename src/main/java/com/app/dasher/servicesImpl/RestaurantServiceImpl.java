package com.app.dasher.servicesImpl;

import com.app.dasher.models.Resturant.Ratings;
import com.app.dasher.models.Resturant.Restaurant;
import com.app.dasher.models.Resturant.Review.Review;
import com.app.dasher.models.Resturant.Review.dto.ReviewDto;
import com.app.dasher.models.Resturant.ServiceType;
import com.app.dasher.models.Resturant.dto.ListRestaurantConfigDto;
import com.app.dasher.models.Resturant.dto.RestaurantDto;
import com.app.dasher.models.Resturant.menu.MenuItems;
import com.app.dasher.models.Resturant.menu.dto.MenuListDto;
import com.app.dasher.models.dashboard.MenuBriefInfoDto;
import com.app.dasher.models.dashboard.RestaurantDetailFilterDto;
import com.app.dasher.services.RestaurantService;
import com.app.dasher.utils.Constant;
import com.app.dasher.utils.Utils;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
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
  public Object createRestaurant(RestaurantDto restaurantDto) {
    Restaurant restaurantDetails = new Restaurant();
    try {
      BeanUtils.copyProperties(restaurantDetails, restaurantDto);
    } catch (Exception e) {
      e.printStackTrace();
    }
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
    restaurantDetails.setOpeningTime(LocalTime.parse(restaurantDto.getOpeningHours(), formatter));
    restaurantDetails.setClosingTime(LocalTime.parse(restaurantDto.getClosingHours(), formatter));
    restaurantDetails.setId(Utils.generateId());
    restaurantDetails.setUpdatedAt(Utils.getCurrentTime());
    restaurantDetails.setCreatedAt(Utils.getCurrentTime());
    restaurantDetails.setActive(true);
    return mongoOperations.save(restaurantDetails).getId();
  }

  @Override
  public Object getRestaurantDetails(String id) {
    Query query = new Query(Criteria.where(Constant.COMMON_ID).is(id));
    return mongoOperations.findOne(query, Restaurant.class);
  }

  @Override
  public Object listRestaurantBasedUponConfig(ListRestaurantConfigDto listRestaurantConfigDto) {
    Query query = new Query();

    if (null != listRestaurantConfigDto.getName()) {
      query.addCriteria(Criteria.where("name").regex(
          Pattern.compile(listRestaurantConfigDto.getName(),
              Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE)));
    }

    if (null != listRestaurantConfigDto.getServiceType()) {
      query.addCriteria(new Criteria().orOperator(
          Criteria.where("serviceType").is(listRestaurantConfigDto.getServiceType()),
          Criteria.where("serviceType").gt(ServiceType.BOTH)));

      if (listRestaurantConfigDto.getRatings() > 0.0) {
        if (listRestaurantConfigDto.getServiceType().equals(ServiceType.DINNING)) {
          query.addCriteria(
              Criteria.where("diningReview.rating").gte(listRestaurantConfigDto.getRatings()));
        } else {
          query.addCriteria(
              Criteria.where("serviceReview.rating").gte(listRestaurantConfigDto.getRatings()));
        }
      }
    }

    if (null != listRestaurantConfigDto.getCuisine()) {
      query.addCriteria(Criteria.where("cuisine").is(listRestaurantConfigDto.getCuisine()));
    }

//    if (listRestaurantConfigDto.getCurrentTimeInHours() > 0) {
//      LocalTime currentTime = LocalTime.of(listRestaurantConfigDto.getCurrentTimeInHours(), 0);
//      query.addCriteria(new Criteria().andOperator(
//          Criteria.where("openingTime").lt(currentTime),
//          Criteria.where("closingTime").gt(currentTime)));
//    }

    if (listRestaurantConfigDto.getLng() != null && listRestaurantConfigDto.getLng() != null
        && listRestaurantConfigDto.getDistanceInKm() > 0.0) {
//      Circle myCircle = new Circle(new Point(listRestaurantConfigDto.getLng(),
//          listRestaurantConfigDto.getLat()),
//          new Distance(listRestaurantConfigDto.getDistanceInKm(), Metrics.KILOMETERS));
//      query.addCriteria(Criteria.where("location").withinSphere(myCircle));
    }
    return mongoOperations.find(query, Restaurant.class);
  }

  @Override
  public Object getRestaurantMenuCustomizableList(String restaurantId, String menuId) {
    Restaurant restaurant = (Restaurant) getRestaurantDetails(restaurantId);

    int menuItemMatchedIndex = IntStream.range(0, restaurant.getMenuItemsList().size())
        .filter(index -> restaurant.getMenuItemsList().get(index).getId().equalsIgnoreCase(menuId))
        .findFirst()
        .getAsInt();

    return restaurant.getMenuItemsList().get(menuItemMatchedIndex).getCustomizations();
  }

  @Override
  public Object createMenuItemForRestaurant(String restaurantId, MenuItems menuItems) {
    Restaurant restaurant = (Restaurant) getRestaurantDetails(restaurantId);
    menuItems.setId(Utils.generateId());
    if (null != restaurant) {
      if (null != restaurant.getMenuItemsList() && restaurant.getMenuItemsList().size() > 0) {
        List<MenuItems> existingMenuItemsList = new ArrayList<>();
        existingMenuItemsList.addAll(restaurant.getMenuItemsList());
        existingMenuItemsList.add(menuItems);
        restaurant.setMenuItemsList(existingMenuItemsList);
        mongoOperations.save(restaurant);
      } else {
        List<MenuItems> existingMenuItemsList = new ArrayList<>();
        existingMenuItemsList.add(menuItems);
        restaurant.setMenuItemsList(existingMenuItemsList);
        mongoOperations.save(restaurant);
      }
      return "Successfully Added";
    } else {
      return "Restaurant not found";
    }
  }

  @Override
  public MenuListDto getMenuItemsBasedUponFilters(RestaurantDetailFilterDto filterDto) {
    Restaurant restaurant = (Restaurant) getRestaurantDetails(filterDto.getRestaurantId());
    List<MenuItems> menuItemsList = restaurant.getMenuItemsList();
    MenuListDto menuListDto = new MenuListDto();

    List<MenuBriefInfoDto> diningMenuList = new ArrayList<>();
    List<MenuBriefInfoDto> pickUpMenuList = new ArrayList<>();

    if (null != menuItemsList && menuItemsList.size() > 0) {
      for (MenuItems menuItems : menuItemsList) {
        MenuBriefInfoDto menuBriefInfoDto = new MenuBriefInfoDto();
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
    Restaurant restaurant = (Restaurant) getRestaurantDetails(id);

    if (review.isDinning()) {
      if (restaurant.getDiningReview() != null) {
        if (null != restaurant.getDiningReview().getReviewList()
            && restaurant.getDiningReview().getReviewList().size() > 0) {
          List<Review> reviewList = restaurant.getDiningReview().getReviewList();
          reviewList.add(review);
          restaurant.getDiningReview().setReviewList(reviewList);
          mongoOperations.save(restaurant);
        } else {
          List<Review> reviewList = new ArrayList<>();
          reviewList.add(review);
          restaurant.getDiningReview().setReviewList(reviewList);
          mongoOperations.save(restaurant);
        }
      } else {
        Ratings ratings = new Ratings();
        List<Review> reviewList = new ArrayList<>();
        reviewList.add(review);
        ratings.setReviewList(reviewList);
        restaurant.setDiningReview(ratings);
        mongoOperations.save(restaurant);
      }
    } else {
      if (restaurant.getServiceReview() != null) {
        if (null != restaurant.getServiceReview().getReviewList()
            && restaurant.getServiceReview().getReviewList().size() > 0) {
          List<Review> reviewList = restaurant.getServiceReview().getReviewList();
          reviewList.add(review);
          restaurant.getServiceReview().setReviewList(reviewList);
          mongoOperations.save(restaurant);
        } else {
          List<Review> reviewList = new ArrayList<>();
          reviewList.add(review);
          restaurant.getServiceReview().setReviewList(reviewList);
          mongoOperations.save(restaurant);
        }
      } else {
        Ratings ratings = new Ratings();
        List<Review> reviewList = new ArrayList<>();
        reviewList.add(review);
        ratings.setReviewList(reviewList);
        restaurant.setServiceReview(ratings);
        mongoOperations.save(restaurant);
      }
    }
    return "Successfully Added";
  }

  @Override
  public Object listReviewForRestaurant(String id, int page, int size) {
    Restaurant restaurant = (Restaurant) getRestaurantDetails(id);
    List<Review> reviewList = new ArrayList<>();

    if (null != restaurant.getDiningReview() && null != restaurant.getDiningReview().getReviewList()
        && restaurant.getDiningReview().getReviewList().size() > 0) {
      reviewList.addAll(restaurant.getDiningReview().getReviewList());
    }

    if (null != restaurant.getServiceReview() && null != restaurant.getServiceReview()
        .getReviewList() && restaurant.getServiceReview().getReviewList().size() > 0) {
      reviewList.addAll(restaurant.getServiceReview().getReviewList());
    }
    return reviewList;
  }
}
