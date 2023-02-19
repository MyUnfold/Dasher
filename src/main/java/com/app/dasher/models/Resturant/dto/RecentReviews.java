package com.app.dasher.models.Resturant.dto;

import java.util.List;

/**
 * @author Paly
 * @version 1.0
 * @date 26/11/22 8:43 pm
 * @company NextUp
 */
public class RecentReviews {

  private String name;
  private String profilePictureUrl;
  private String comment;
  private List<String> images;
  private double overAllReview;
  private ReviewerDto diningReview;
  private ReviewerDto serviceReview;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getProfilePictureUrl() {
    return profilePictureUrl;
  }

  public void setProfilePictureUrl(String profilePictureUrl) {
    this.profilePictureUrl = profilePictureUrl;
  }

  public String getComment() {
    return comment;
  }

  public void setComment(String comment) {
    this.comment = comment;
  }

  public List<String> getImages() {
    return images;
  }

  public void setImages(List<String> images) {
    this.images = images;
  }

  public double getOverAllReview() {
    return overAllReview;
  }

  public void setOverAllReview(double overAllReview) {
    this.overAllReview = overAllReview;
  }

  public ReviewerDto getDiningReview() {
    return diningReview;
  }

  public void setDiningReview(ReviewerDto diningReview) {
    this.diningReview = diningReview;
  }

  public ReviewerDto getServiceReview() {
    return serviceReview;
  }

  public void setServiceReview(ReviewerDto serviceReview) {
    this.serviceReview = serviceReview;
  }
}
