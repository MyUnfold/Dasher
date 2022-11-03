package com.app.dasher.servicesImpl;

import com.app.dasher.models.admin.AdminProperties;
import com.app.dasher.models.admin.PROPERTY_TYPE;
import com.app.dasher.services.AdminService;
import com.app.dasher.utils.Utils;
import java.util.List;
import java.util.Queue;
import java.util.regex.Pattern;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

/**
 * @author Paly
 * @version 1.0
 * @date 03/11/22 4:37 am
 * @company NextUp
 */

@Service
public class AdminServiceImpl implements AdminService {

  @Autowired
  MongoOperations mongoOperations;

  @Override
  public Object createProperty(List<AdminProperties> adminPropertiesList) {

    for (AdminProperties adminProperties : adminPropertiesList) {
      AdminProperties adminPropertiesDetails = new AdminProperties();
      try {
        BeanUtils.copyProperties(adminPropertiesDetails, adminProperties);
      } catch (Exception e) {
        e.printStackTrace();
      }

      adminPropertiesDetails.setId(Utils.generateId());
      adminPropertiesDetails.setUpdatedAt(Utils.getCurrentTime());
      adminPropertiesDetails.setCreatedAt(Utils.getCurrentTime());
      adminPropertiesDetails.setActive(true);
      mongoOperations.save(adminPropertiesDetails);
    }
    return adminPropertiesList;
  }

  @Override
  public Object getPropertyBasedUponFilter(PROPERTY_TYPE property_type, String keyword) {
    Query query = new Query();
    query.addCriteria(Criteria.where("property_type").is(property_type));

    if(null != keyword){
      query.addCriteria(Criteria.where("name").regex(Pattern.compile(keyword, Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE)));
    }
    return mongoOperations.find(query, AdminProperties.class);
  }


}
