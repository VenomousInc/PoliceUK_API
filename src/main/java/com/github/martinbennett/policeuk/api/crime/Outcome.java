package com.github.martinbennett.policeuk.api.crime;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "category",
        "date",
        "crime",
        "person_id"
})
public class Outcome {

    @JsonProperty("category")
    public OutcomeCategory outcomeCategory;
    @JsonProperty("date")
    public String date;
    @JsonProperty("crime")
    public Crime crime;
    @JsonProperty("person_id")
    public String personId;

    @Override
    public String toString() {
        return "Outcome{" +
                "outcomeCategory=" + outcomeCategory +
                ", date='" + date + '\'' +
                ", personId=" + personId +
                ", crime=" + crime +
                '}';
    }

    @JsonIgnore
    public String toPrettyPrint() {
        final StringBuilder sb = new StringBuilder("== Outcome ==");

        if(outcomeCategory != null)
            sb.append('\n').append(outcomeCategory);

        sb.append(String.format("%nDate: %s", date));

        if(crime != null)
            sb.append(String.format("%nCrime: %s", crime));

        sb.append(String.format("%nPersonId: %s", personId));

        return sb.toString();
    }

}