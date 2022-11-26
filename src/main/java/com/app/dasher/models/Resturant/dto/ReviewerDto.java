package com.app.dasher.models.Resturant.dto;

/**
 * @author Paly
 * @version 1.0
 * @date 26/11/22 8:24 pm
 * @company NextUp
 */
public class ReviewerDto {
  private double ratings;
  private int numberOfReviewers;

  public double getRatings() {
    return ratings;
  }

  public void setRatings(double ratings) {
    this.ratings = ratings;
  }

  public int getNumberOfReviewers() {
    return numberOfReviewers;
  }

  public void setNumberOfReviewers(int numberOfReviewers) {
    this.numberOfReviewers = numberOfReviewers;
  }
}
