package com.app.dasher.models.common;


import javax.validation.constraints.NotNull;

/**
 * @author Paly
 * @version 1.0
 * @date 03/06/21 11:25 PM
 * @company NextUp
 */
public class Address {
    @NotNull
    private String city;
    private String state;
    private String stateCode;
    private String country;
    private String postCode;
    private double geoLat;
    private double geoLng;
    private String customAddress;
    private String currentCity;
    private String currency;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getStateCode() {
        return stateCode;
    }

    public void setStateCode(String stateCode) {
        this.stateCode = stateCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public double getGeoLat() {
        return geoLat;
    }

    public void setGeoLat(double geoLat) {
        this.geoLat = geoLat;
    }

    public double getGeoLng() {
        return geoLng;
    }

    public void setGeoLng(double geoLng) {
        this.geoLng = geoLng;
    }

    public String getCustomAddress() {
        return customAddress;
    }

    public void setCustomAddress(String customAddress) {
        this.customAddress = customAddress;
    }

    public String getCurrentCity() {
        return currentCity;
    }

    public void setCurrentCity(String currentCity) {
        this.currentCity = currentCity;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
