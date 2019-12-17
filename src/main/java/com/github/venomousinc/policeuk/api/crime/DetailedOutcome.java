package com.github.venomousinc.policeuk.api.crime;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "outcomes",
        "crime"
})
public class DetailedOutcome {

    @JsonProperty("outcomes")
    public ArrayList<Outcome> outcomes = new ArrayList<>();
    @JsonProperty("crime")
    public Crime crime;

    @JsonIgnore
    public String toPrettyPrint() {
        StringBuilder sb = new StringBuilder("== Detailed Outcome ==");

        if(crime != null)
            sb.append('\n').append(crime.toPrettyPrint());
        if(outcomes != null)
            outcomes.forEach(outcome -> sb.append('\n').append(outcome.toPrettyPrint()));

        sb.append("\n<----> <----> <---->");

        return sb.toString();
    }

    @Override
    public String toString() {
        return "DetailedOutcome{" +
                "outcomes=" + outcomes +
                ", crime=" + crime +
                '}';
    }
}
