package com.github.venomousinc.policeuk.api;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "bio",
        "contact_details",
        "name",
        "rank"
})
public class Person {

    @JsonProperty("bio")
    public String bio;
    @JsonProperty("contact_details")
    public ContactDetails contactDetails;
    @JsonProperty("name")
    public String name;
    @JsonProperty("rank")
    public String rank;

    public String toPrettyPrint() {
        return String.format(
                "# Person #%n bio: %s%n contactDetails: %s%n name: %s%n rank: %s", this.bio, this.contactDetails, this.name, this.rank);
    }

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
