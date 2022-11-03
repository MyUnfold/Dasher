package com.app.dasher.models.user;

/**
 * @author Paly
 * @version 1.0
 * @date 03/11/22 4:46 am
 * @company NextUp
 */
public class OtpRequestDto {
  private String sourceInfo;
  private String fullName;

  public String getFullName() {
    return fullName;
  }

  public void setFullName(String fullName) {
    this.fullName = fullName;
  }

  public String getSourceInfo() {
    return sourceInfo;
  }

  public void setSourceInfo(String sourceInfo) {
    this.sourceInfo = sourceInfo;
  }
}
