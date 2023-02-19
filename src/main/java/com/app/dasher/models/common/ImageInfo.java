package com.app.dasher.models.common;

/**
 * @author Paly
 * @version 1.0
 * @date 20/07/21 11:22 AM
 * @company NextUp
 */
public class ImageInfo {

  private String muxId;
  private String imageUrl;
  private Long addedAt;
  private int numberOfLikes;

  public String getMuxId() {
    return muxId;
  }

  public void setMuxId(String muxId) {
    this.muxId = muxId;
  }

  public String getImageUrl() {
    return imageUrl;
  }

  public void setImageUrl(String imageUrl) {
    this.imageUrl = imageUrl;
  }

  public Long getAddedAt() {
    return addedAt;
  }

  public void setAddedAt(Long addedAt) {
    this.addedAt = addedAt;
  }


  public int getNumberOfLikes() {
    return numberOfLikes;
  }

  public void setNumberOfLikes(int numberOfLikes) {
    this.numberOfLikes = numberOfLikes;
  }
}
