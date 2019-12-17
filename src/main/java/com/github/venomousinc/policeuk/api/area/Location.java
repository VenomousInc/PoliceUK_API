package com.github.venomousinc.policeuk.api.area;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author VenomousInc
 * @since 10/05/2019
 */
public class Location {

    @JsonProperty("longitude")
    public String longitude;
    @JsonProperty("latitude")
    public String latitude;

    @Override
    public String toString() {
        return "Location{" +
                "longitude='" + longitude + '\'' +
                ", latitude='" + latitude + '\'' +
                '}';
    }
}