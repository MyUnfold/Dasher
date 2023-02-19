package com.app.dasher.services;

import com.app.dasher.models.Resturant.dto.ListRestaurantConfigDto;
import com.app.dasher.models.dashboard.RestaurantDetailFilterDto;

/**
 * @author Paly
 * @version 1.0
 * @date 26/11/22 7:05 pm
 * @company NextUp
 */
public interface HomeService {

  Object getUserDashboard(ListRestaurantConfigDto listRestaurantConfigDto);

  Object getRestaurantDetails(RestaurantDetailFilterDto filterDto);

}
