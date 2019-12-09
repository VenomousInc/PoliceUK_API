package com.github.martinbennett.policeuk.api.crime;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.github.martinbennett.policeuk.api.area.StreetLocation;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "persistent_id",
        "id",
        "month",
        "category",
        "context",
        "location_type",
        "location_subtype",
        "location",
        "outcome_status"
})
public class Crime {

    @JsonProperty("persistent_id")
    public String persistentId;
    @JsonProperty("id")
    public long id;
    @JsonProperty("month")
    public String month;
    @JsonProperty("category")
    public String category;
    @JsonProperty("location_type")
    public String locationType;
    @JsonProperty("location_subtype")
    public String locationSubtype;
    @JsonProperty("location")
    public StreetLocation location;
    @JsonProperty("context")
    public String context;
    @JsonProperty("outcome_status")
    public OutcomeStatus outcomeStatus;

    @Override
    public String toString() {
        return "Crime{" +
                "persistentId='" + persistentId + '\'' +
                ", id=" + id +
                ", month='" + month + '\'' +
                ", category='" + category + '\'' +
                ", locationType='" + locationType + '\'' +
                ", locationSubtype='" + locationSubtype + '\'' +
                ", location=" + location +
                ", context='" + context + '\'' +
                ", outcomeStatus=" + outcomeStatus +
                '}';
    }

    @JsonIgnore
    public String toPrettyPrint() {
        final StringBuilder sb = new StringBuilder();

        sb.append("=== Crime ===");
        sb.append(String.format("%nPID: %s, API ID: %d] (Month: %s)", persistentId, id, month));
        sb.append(String.format("%nCrime Category: %s", category));
        sb.append(String.format("%nLocation Type: '%s', Subtype: %s", locationType, locationSubtype));
        if(location != null)
            sb.append('\n').append(location.toPrettyPrint());
        sb.append(String.format("%nContext: %s", context));
        if(outcomeStatus != null)
            sb.append('\n').append(outcomeStatus.toPrettyPrint());

        return sb.toString();
    }
}