package com.app.dasher.services;

import com.app.dasher.models.Resturant.Restaurants;
import com.app.dasher.models.Resturant.dto.ListRestaurantConfigDto;
import com.app.dasher.models.Resturant.menu.MenuItems;

/**
 * @author Paly
 * @version 1.0
 * @date 24/11/22 8:28 pm
 * @company NextUp
 */

public interface RestaurantService {
  Object createRestaurant(Restaurants restaurants);
  Object getRestaurantDetails(String id);
  Object listRestaurantBasedUponConfig(ListRestaurantConfigDto listRestaurantConfigDto);

  Object getRestaurantMenuCustomizableList(String restaurantId, String menuId);

  Object createMenuItemForRestaurant(String restaurantId, MenuItems menuItems);
}
