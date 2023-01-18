package com.app.dasher.services;

import com.app.dasher.models.Resturant.Restaurant;
import com.app.dasher.models.Resturant.Review.dto.ReviewDto;
import com.app.dasher.models.Resturant.dto.ListRestaurantConfigDto;
import com.app.dasher.models.Resturant.dto.RestaurantDto;
import com.app.dasher.models.Resturant.menu.MenuItems;
import com.app.dasher.models.Resturant.menu.dto.MenuListDto;
import com.app.dasher.models.dashboard.RestaurantDetailFilterDto;

/**
 * @author Paly
 * @version 1.0
 * @date 24/11/22 8:28 pm
 * @company NextUp
 */

public interface RestaurantService {
  Object createRestaurant(RestaurantDto restaurant);
  Object getRestaurantDetails(String id);
  Object listRestaurantBasedUponConfig(ListRestaurantConfigDto listRestaurantConfigDto);

  Object getRestaurantMenuCustomizableList(String restaurantId, String menuId);

  Object createMenuItemForRestaurant(String restaurantId, MenuItems menuItems);

  MenuListDto getMenuItemsBasedUponFilters(RestaurantDetailFilterDto filterDto);

  Object addReviewToRestaurants(String id, ReviewDto review);

  Object listReviewForRestaurant(String id, int page, int size);
}
