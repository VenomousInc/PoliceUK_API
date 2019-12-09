package com.github.martinbennett.policeuk.api.area;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "id",
        "name"
})
public class Street {

    @JsonProperty("id")
    public long id;
    @JsonProperty("name")
    public String name;

    @Override
    public String toString() {
        return "Street{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    @JsonIgnore
    public String toPrettyPrint() {
        final StringBuilder sb = new StringBuilder("== Street ==");

        sb.append(String.format("%nStreet ID: %d", id));
        sb.append(String.format(", Street Name: %s", name));

        return sb.toString();
    }
}