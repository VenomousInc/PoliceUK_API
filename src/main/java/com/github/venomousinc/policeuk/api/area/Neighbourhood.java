package com.github.venomousinc.policeuk.api.area;


import java.util.ArrayList;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.github.venomousinc.policeuk.api.ContactDetails;
import com.github.venomousinc.policeuk.api.Link;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "id",
        "url_force",
        "name",
        "welcome_message",
        "centre",
        "description",
        "population",
        "contact_details",
        "links",
        "locations"
})
public class Neighbourhood {

    @JsonProperty("id")
    public String id;
    @JsonProperty("url_force")
    public String urlForce;
    @JsonProperty("name")
    public String name;
    @JsonProperty("welcome_message")
    public String welcomeMessage;
    @JsonProperty("centre")
    public Location centre;
    @JsonProperty("description")
    public String description;
    @JsonProperty("population")
    public String population;
    @JsonProperty("contact_details")
    public ContactDetails contactDetails;
    @JsonProperty("links")
    public ArrayList<Link> links = new ArrayList<>();
    @JsonProperty("locations")
    public ArrayList<HoodLocation> locations = new ArrayList<>();

    public String getSimpleResponse() {
        return String.format("ID: %s, name: %s", id, name);
    }

    @Override
    public String toString() {
        return "Neighbourhood{" +
                "id='" + id + '\'' +
                ", urlForce='" + urlForce + '\'' +
                "\n, name='" + name + '\'' +
                "\n, welcomeMessage='" + welcomeMessage + '\'' +
                "\n, centre=" + centre.toString() +
                "\n, description='" + description + '\'' +
                "\n, population='" + population + '\'' +
                "\n, contactDetails=" + contactDetails +
                "\n, links=" + links +
                "\n, locations=" + locations +
                '}';
    }
}