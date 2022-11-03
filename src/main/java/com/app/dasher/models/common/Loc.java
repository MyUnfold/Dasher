package com.app.dasher.models.common;

import java.util.List;

/**
 * @author Paly
 * @version 1.0
 * @date 03/06/21 11:23 PM
 * @company NextUp
 */
public class Loc {
    private String type;
    private List<Double> coordinates;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Double> getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(List<Double> coordinates) {
        this.coordinates = coordinates;
    }
}
