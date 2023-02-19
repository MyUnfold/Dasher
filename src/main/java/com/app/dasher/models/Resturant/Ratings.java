package com.app.dasher.models.Resturant;

import com.app.dasher.models.Resturant.Review.Review;
import java.util.List;

/**
 * @author Paly
 * @version 1.0
 * @date 24/11/22 5:37 pm
 * @company NextUp
 */
public class Ratings {

  private double rating;
  private int numberOfUsers;
  private List<Review> reviewList;

  public List<Review> getReviewList() {
    return reviewList;
  }

  public void setReviewList(List<Review> reviewList) {
    this.reviewList = reviewList;
  }

  public double getRating() {
    return rating;
  }

  public void setRating(double rating) {
    this.rating = rating;
  }

  public int getNumberOfUsers() {
    return numberOfUsers;
  }

  public void setNumberOfUsers(int numberOfUsers) {
    this.numberOfUsers = numberOfUsers;
  }
}
