package com.app.dasher.servicesImpl;

import com.app.dasher.models.Resturant.Restaurants;
import com.app.dasher.models.Resturant.dto.ListRestaurantConfigDto;
import com.app.dasher.models.Resturant.dto.RestaurantDetailDto;
import com.app.dasher.models.Resturant.dto.RestaurantViewMoreInfoDto;
import com.app.dasher.models.Resturant.dto.ReviewerDto;
import com.app.dasher.models.dashboard.ListCoupons;
import com.app.dasher.models.dashboard.ListMoods;
import com.app.dasher.models.dashboard.RestaurantDetailFilterDto;
import com.app.dasher.models.dashboard.RestaurantInfoDto;
import com.app.dasher.models.dashboard.UserDashboardDto;
import com.app.dasher.services.AdminService;
import com.app.dasher.services.HomeService;
import com.app.dasher.services.RestaurantService;
import com.app.dasher.utils.Utils;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Service;

/**
 * @author Paly
 * @version 1.0
 * @date 26/11/22 7:05 pm
 * @company NextUp
 */

@Service
public class HomeServiceImpl implements HomeService {

  @Autowired
  MongoOperations mongoOperations;

  @Autowired
  AdminService adminService;

  @Autowired
  RestaurantService restaurantService;


  @Override
  public Object getUserDashboard(ListRestaurantConfigDto listRestaurantConfigDto) {
    UserDashboardDto userDashboardDto = new UserDashboardDto();

    List<ListMoods> moodsList = (List<ListMoods>) adminService.listOfMoods();
    List<ListCoupons> couponsList = (List<ListCoupons>) adminService.listOfCoupon();
    List<Restaurants> restaurantsList = (List<Restaurants>) restaurantService.listRestaurantBasedUponConfig(listRestaurantConfigDto);

    List<RestaurantInfoDto> recommendedRestaurants = new ArrayList<>();

    if(null != restaurantsList && restaurantsList.size()>0){
      for(Restaurants restaurant: restaurantsList){
        RestaurantInfoDto restaurantInfoDto = new RestaurantInfoDto();
        restaurantInfoDto.setName(restaurant.getName());
        restaurantInfoDto.setCuisine(restaurant.getCuisine());
        restaurantInfoDto.setImageUrl(restaurant.getLogoUrl());
        restaurantInfoDto.setId(restaurant.getId());
        restaurantInfoDto.setOpen(true);
        restaurantInfoDto.setRatings(ThreadLocalRandom.current().nextDouble(0.0, 10.0));
        restaurantInfoDto.setDeliveryTime(Utils.randomInteger(10, 50));
        recommendedRestaurants.add(restaurantInfoDto);
      }
    }

    userDashboardDto.setMoodsList(moodsList);
    userDashboardDto.setCouponList(couponsList);
    userDashboardDto.setMustTry(recommendedRestaurants);
    userDashboardDto.setRecommendation(recommendedRestaurants);
    return userDashboardDto;
  }

  @Override
  public Object getRestaurantDetails(RestaurantDetailFilterDto filterDto) {
    Restaurants restaurants = (Restaurants) restaurantService.getRestaurantDetails(filterDto.getRestaurantId());

    RestaurantDetailDto restaurantInfoDto = new RestaurantDetailDto();
    RestaurantViewMoreInfoDto restaurantViewMoreInfoDto = new RestaurantViewMoreInfoDto();

    restaurantInfoDto.setName(restaurants.getName());
    restaurantInfoDto.setId(restaurants.getId());
    restaurantInfoDto.setLogoUrl(restaurants.getLogoUrl());
    restaurantInfoDto.setLat(restaurants.getLocation().getCoordinates().get(1));
    restaurantInfoDto.setLng(restaurants.getLocation().getCoordinates().get(0));
    restaurantInfoDto.setTags(restaurants.getTags());
    restaurantInfoDto.setMenuItemsList(restaurantService.getMenuItemsBasedUponFilters(filterDto));

    ReviewerDto reviewerDto = new ReviewerDto();
    reviewerDto.setNumberOfReviewers(Utils.randomInteger(0, 100));
    reviewerDto.setRatings(ThreadLocalRandom.current().nextDouble(0.0, 10.0));

    ReviewerDto reviewerDto1 = new ReviewerDto();
    reviewerDto1.setNumberOfReviewers(Utils.randomInteger(0, 100));
    reviewerDto1.setRatings(ThreadLocalRandom.current().nextDouble(0.0, 10.0));

    restaurantInfoDto.setDiningReview(reviewerDto);
    restaurantInfoDto.setServiceReview(reviewerDto1);

    restaurantViewMoreInfoDto.setCustomAddress(restaurants.getCustomAddress());
    restaurantViewMoreInfoDto.setLat(restaurants.getLocation().getCoordinates().get(1));
    restaurantViewMoreInfoDto.setLng(restaurants.getLocation().getCoordinates().get(0));
    restaurantViewMoreInfoDto.setMetaLine("Quick bites, Fast Food");
    restaurantViewMoreInfoDto.setName(restaurants.getName());

    restaurantViewMoreInfoDto.setServiceReview(reviewerDto);
    restaurantViewMoreInfoDto.setDiningReview(reviewerDto1);
    restaurantViewMoreInfoDto.setLogoUrl(restaurants.getLogoUrl());
    restaurantViewMoreInfoDto.setImageUrl(restaurants.getImageUrl());

    restaurantViewMoreInfoDto.setTrendingMenu(restaurantService.getMenuItemsBasedUponFilters(filterDto));
    restaurantInfoDto.setRestaurantViewMoreInfoDto(restaurantViewMoreInfoDto);
    return restaurantInfoDto;
  }
}
