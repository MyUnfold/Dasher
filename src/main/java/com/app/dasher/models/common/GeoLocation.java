package com.app.dasher.models.common;


/**
 * @author Paly
 * @version 1.0
 * @date 03/06/21 11:23 PM
 * @company NextUp
 */
public class GeoLocation {
    private String name;
    private Loc loc;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Loc getLoc() {
        return loc;
    }

    public void setLoc(Loc loc) {
        this.loc = loc;
    }
}
