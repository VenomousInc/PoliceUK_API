package com.github.venomousinc.policeuk.api.crime;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "category",
        "date"
})
public class  OutcomeStatus {

    @JsonProperty("category")
    public String category;
    @JsonProperty("date")
    public String date;

    @Override
    public String toString() {
        return "OutcomeStatus{" +
                "category='" + category + '\'' +
                ", date='" + date + '\'' +
                '}';
    }

    @JsonIgnore
    public String toPrettyPrint() {
        final StringBuilder sb = new StringBuilder("== Outcome Status ==");

        sb.append(String.format("%nCategory: %s", category));
        sb.append(String.format("%nDate: %s", date));

        return sb.toString();
    }

}