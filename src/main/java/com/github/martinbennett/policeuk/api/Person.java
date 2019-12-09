package com.github.martinbennett.policeuk.api;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.github.martinbennett.policeuk.api.ContactDetails;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "bio",
        "contact_details",
        "name",
        "rank"
})
public class Person {

    @JsonProperty("bio")
    public Object bio;
    @JsonProperty("contact_details")
    public ContactDetails contactDetails;
    @JsonProperty("name")
    public String name;
    @JsonProperty("rank")
    public String rank;

    @Override
    public String toString() {
        return "Person{" +
                "bio=" + bio +
                ", contactDetails=" + contactDetails +
                ", name='" + name + '\'' +
                ", rank='" + rank + '\'' +
                '}';
    }
}
