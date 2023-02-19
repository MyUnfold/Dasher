package com.app.dasher.models.Resturant.Review;

import java.util.List;

/**
 * @author Paly
 * @version 1.0
 * @date 24/11/22 5:45 pm
 * @company NextUp
 */
public class Review {

  private String profilePictureUrl;
  private String name;
  private String content;
  private double score;

  private List<String> pictureUrl;

  public List<String> getPictureUrl() {
    return pictureUrl;
  }

  public void setPictureUrl(List<String> pictureUrl) {
    this.pictureUrl = pictureUrl;
  }

  public double getScore() {
    return score;
  }

  public void setScore(double score) {
    this.score = score;
  }

  public String getProfilePictureUrl() {
    return profilePictureUrl;
  }

  public void setProfilePictureUrl(String profilePictureUrl) {
    this.profilePictureUrl = profilePictureUrl;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }
}
