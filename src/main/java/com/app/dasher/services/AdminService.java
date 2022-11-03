package com.app.dasher.services;

import com.app.dasher.models.admin.AdminProperties;
import com.app.dasher.models.admin.PROPERTY_TYPE;
import java.util.List;

/**
 * @author Paly
 * @version 1.0
 * @date 03/11/22 4:37 am
 * @company NextUp
 */
public interface AdminService {

  Object createProperty(List<AdminProperties> adminPropertiesList);
  Object getPropertyBasedUponFilter(PROPERTY_TYPE property_type, String keyword);

}
