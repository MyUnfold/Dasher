package com.app.dasher.models.common;

import org.springframework.security.core.GrantedAuthority;

/**
 * @author Paly
 * @version 1.0
 * @date 03/11/22 3:35 am
 * @company NextUp
 */
public enum Role implements GrantedAuthority {
  ROLE_USER, ROLE_SUPER_ADMIN, ROLE_ADMIN;

  public String getAuthority() {
    return name();
  }
}
