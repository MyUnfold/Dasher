package com.app.dasher.models.orders;

import com.app.dasher.models.Resturant.menu.MenuItems;
import com.app.dasher.models.common.BaseModel;
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
 * @date 26/11/22 5:44 pm
 * @company NextUp
 */


@Getter
@Setter
@Document(collection = "tbl_order_history")
public class OrderHistory extends BaseModel {

  @JsonIgnore
  @Id
  private ObjectId objectId;
  private String id;

  private String name;
  private List<MenuItems> menuItemsList;
  private Long orderPlacedTime;
  private List<String> images;
  private OrderStatus orderStatus;

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

  public List<MenuItems> getMenuItemsList() {
    return menuItemsList;
  }

  public void setMenuItemsList(
      List<MenuItems> menuItemsList) {
    this.menuItemsList = menuItemsList;
  }

  public Long getOrderPlacedTime() {
    return orderPlacedTime;
  }

  public void setOrderPlacedTime(Long orderPlacedTime) {
    this.orderPlacedTime = orderPlacedTime;
  }

  public List<String> getImages() {
    return images;
  }

  public void setImages(List<String> images) {
    this.images = images;
  }

  public OrderStatus getOrderStatus() {
    return orderStatus;
  }

  public void setOrderStatus(OrderStatus orderStatus) {
    this.orderStatus = orderStatus;
  }
}
