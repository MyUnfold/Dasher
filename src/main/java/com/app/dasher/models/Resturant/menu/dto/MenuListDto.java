package com.app.dasher.models.Resturant.menu.dto;

import com.app.dasher.models.dashboard.MenuBriefInfoDto;
import java.util.List;

/**
 * @author Paly
 * @version 1.0
 * @date 26/11/22 9:14 pm
 * @company NextUp
 */
public class MenuListDto {
  private List<MenuBriefInfoDto> diningMenuList;
  private List<MenuBriefInfoDto> pickUpMenuList;

  public List<MenuBriefInfoDto> getDiningMenuList() {
    return diningMenuList;
  }

  public void setDiningMenuList(
      List<MenuBriefInfoDto> diningMenuList) {
    this.diningMenuList = diningMenuList;
  }

  public List<MenuBriefInfoDto> getPickUpMenuList() {
    return pickUpMenuList;
  }

  public void setPickUpMenuList(
      List<MenuBriefInfoDto> pickUpMenuList) {
    this.pickUpMenuList = pickUpMenuList;
  }
}
