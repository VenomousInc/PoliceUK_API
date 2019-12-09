package com.github.martinbennett.policeuk.api.area;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "street",
        "latitude",
        "longitude"
})
public class StreetLocation extends Location {

    @JsonProperty("street")
    public Street street;
    @Override
    public String toString() {
        return "StreetLocation{" +
                "street=" + street +
                ", latitude='" + latitude + '\'' +
                ", longitude='" + longitude + '\'' +
                '}';
    }

    @JsonIgnore
    public String toPrettyPrint() {
        final StringBuilder sb = new StringBuilder("== StreetLocation ==");

        sb.append(String.format("%nLatitude: %s, Longitude: %s", latitude, longitude));
        if(street != null)
            sb.append('\n').append(street.toPrettyPrint());

        return sb.toString();
    }

}