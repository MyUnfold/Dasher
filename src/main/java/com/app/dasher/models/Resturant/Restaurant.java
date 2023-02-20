package com.app.dasher.models.Resturant;

import com.app.dasher.models.Resturant.menu.MenuItems;
import com.app.dasher.models.common.BaseModel;
import com.app.dasher.models.common.Loc;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author Paly
 * @version 1.0
 * @date 24/11/22 5:22 pm
 * @company NextUp
 */

@Getter
@Setter
@Document(collection = "tbl_restaurants")
public class Restaurant extends BaseModel {

  @JsonIgnore
  @Id
  private ObjectId objectId;
  private String id;
  private String name;
  private String tagLine;
  private List<String> tags;
  private List<String> imageUrl;
  private Loc location;
  private String logoUrl;
  private Ratings diningReview;
  private Ratings serviceReview;
  private ServiceType serviceType;
  private String customAddress;
  private int openingTime;
  private int closingTime;
  private ContactInfo contactInfo;
  private List<MenuItems> menuItemsList;
  private List<String> cuisine;

  public List<String> getImageUrl() {
    return imageUrl;
  }

  public void setImageUrl(List<String> imageUrl) {
    this.imageUrl = imageUrl;
  }

  public List<String> getCuisine() {
    return cuisine;
  }

  public void setCuisine(List<String> cuisine) {
    this.cuisine = cuisine;
  }

  public ObjectId getObjectId() {
    return objectId;
  }

  public void setObjectId(ObjectId objectId) {
    this.objectId = objectId;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getTagLine() {
    return tagLine;
  }

  public void setTagLine(String tagLine) {
    this.tagLine = tagLine;
  }

  public List<String> getTags() {
    return tags;
  }

  public void setTags(List<String> tags) {
    this.tags = tags;
  }

  public Loc getLocation() {
    return location;
  }

  public void setLocation(Loc location) {
    this.location = location;
  }

  public String getLogoUrl() {
    return logoUrl;
  }

  public void setLogoUrl(String logoUrl) {
    this.logoUrl = logoUrl;
  }

  public Ratings getDiningReview() {
    return diningReview;
  }

  public void setDiningReview(Ratings diningReview) {
    this.diningReview = diningReview;
  }

  public Ratings getServiceReview() {
    return serviceReview;
  }

  public void setServiceReview(Ratings serviceReview) {
    this.serviceReview = serviceReview;
  }

  public ServiceType getServiceType() {
    return serviceType;
  }

  public void setServiceType(ServiceType serviceType) {
    this.serviceType = serviceType;
  }

  public String getCustomAddress() {
    return customAddress;
  }

  public void setCustomAddress(String customAddress) {
    this.customAddress = customAddress;
  }

  public int getOpeningTime() {
    return openingTime;
  }

  public void setOpeningTime(int openingTime) {
    this.openingTime = openingTime;
  }

  public int getClosingTime() {
    return closingTime;
  }

  public void setClosingTime(int closingTime) {
    this.closingTime = closingTime;
  }

  public ContactInfo getContactInfo() {
    return contactInfo;
  }

  public void setContactInfo(ContactInfo contactInfo) {
    this.contactInfo = contactInfo;
  }

  public List<MenuItems> getMenuItemsList() {
    return menuItemsList;
  }

  public void setMenuItemsList(List<MenuItems> menuItemsList) {
    this.menuItemsList = menuItemsList;
  }
}
