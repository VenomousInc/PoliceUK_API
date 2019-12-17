package com.github.venomousinc.policeuk.api.crime;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "url",
        "name"
})
public class CrimeCategory {

    @JsonProperty("url")
    public String url;
    @JsonProperty("name")
    public String name;

    @Override
    public String toString() {
        return "CrimeCategory{" +
                "url='" + url + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
