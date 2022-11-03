package com.app.dasher.models.admin;

import com.app.dasher.models.common.BaseModel;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author Paly
 * @version 1.0
 * @date 03/11/22 4:35 am
 * @company NextUp
 */

@Getter
@Setter
@Document(collection = "tbl_admin_properties")
public class AdminProperties extends BaseModel {
  @JsonIgnore
  @Id
  private ObjectId objectId;
  private String id;
  private String name;
  private String imageUrl;
  private PROPERTY_TYPE property_type;

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

  public String getImageUrl() {
    return imageUrl;
  }

  public void setImageUrl(String imageUrl) {
    this.imageUrl = imageUrl;
  }

  public PROPERTY_TYPE getProperty_type() {
    return property_type;
  }

  public void setProperty_type(PROPERTY_TYPE property_type) {
    this.property_type = property_type;
  }
}
