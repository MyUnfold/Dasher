package com.app.dasher.models.common;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * @author Paly
 * @version 1.0
 * @date 03/11/22 3:34 am
 * @company NextUp
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
public class BaseModel {

  @JsonIgnore
  private long createdAt;
  @JsonIgnore
  private long updatedAt;
  @JsonIgnore
  private long updatedBy;
  @JsonIgnore
  private String propertyChanged;
  private Boolean isActive;
  private String ipAddress;
  private Long lastTimeUsed;

  public long getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(long createdAt) {
    this.createdAt = createdAt;
  }

  public long getUpdatedAt() {
    return updatedAt;
  }

  public void setUpdatedAt(long updatedAt) {
    this.updatedAt = updatedAt;
  }

  public long getUpdatedBy() {
    return updatedBy;
  }

  public void setUpdatedBy(long updatedBy) {
    this.updatedBy = updatedBy;
  }

  public String getPropertyChanged() {
    return propertyChanged;
  }

  public void setPropertyChanged(String propertyChanged) {
    this.propertyChanged = propertyChanged;
  }

  public Boolean getActive() {
    return isActive;
  }

  public void setActive(Boolean active) {
    isActive = active;
  }

  public String getIpAddress() {
    return ipAddress;
  }

  public void setIpAddress(String ipAddress) {
    this.ipAddress = ipAddress;
  }

  public Long getLastTimeUsed() {
    return lastTimeUsed;
  }

  public void setLastTimeUsed(Long lastTimeUsed) {
    this.lastTimeUsed = lastTimeUsed;
  }
}
