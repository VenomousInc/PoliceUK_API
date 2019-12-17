package com.github.venomousinc.policeuk.api.crime;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "code",
        "name"
})
public class OutcomeCategory {

    @JsonProperty("code")
    public String code;
    @JsonProperty("name")
    public String name;

    @Override
    public String toString() {
        return "OutcomeCategory{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                '}';
    }


}