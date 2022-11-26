package com.app.dasher.models.Resturant.Review.dto;

import com.app.dasher.models.Resturant.Review.Review;

/**
 * @author Paly
 * @version 1.0
 * @date 26/11/22 9:52 pm
 * @company NextUp
 */
public class ReviewDto extends Review {
  private boolean isDinning;

  public boolean isDinning() {
    return isDinning;
  }

  public void setDinning(boolean dinning) {
    isDinning = dinning;
  }
}
