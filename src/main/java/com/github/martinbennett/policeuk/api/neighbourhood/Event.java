package com.github.martinbennett.policeuk.api.neighbourhood;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.github.martinbennett.policeuk.api.ContactDetails;

/**
 * @author VenomousInc
 * @since 12/12/2019
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "contact_details",
        "description",
        "title",
        "address",
        "type",
        "start_date",
        "end_date"
})
public class Event {

    @JsonProperty("contact_details")
    private ContactDetails contactDetails;
    @JsonProperty("description")
    private Object description;
    @JsonProperty("title")
    private String title;
    @JsonProperty("address")
    private String address;
    @JsonProperty("type")
    private String type;
    @JsonProperty("start_date")
    private String startDate;
    @JsonProperty("end_date")
    private String endDate;

    @JsonProperty("contact_details")
    public ContactDetails getContactDetails() {
        return contactDetails;
    }

    @JsonProperty("contact_details")
    public void setContactDetails(ContactDetails contactDetails) {
        this.contactDetails = contactDetails;
    }

    @JsonProperty("description")
    public Object getDescription() {
        return description;
    }

    @JsonProperty("description")
    public void setDescription(Object description) {
        this.description = description;
    }

    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
    }

    @JsonProperty("address")
    public String getAddress() {
        return address;
    }

    @JsonProperty("address")
    public void setAddress(String address) {
        this.address = address;
    }

    @JsonProperty("type")
    public String getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    @JsonProperty("start_date")
    public String getStartDate() {
        return startDate;
    }

    @JsonProperty("start_date")
    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    @JsonProperty("end_date")
    public String getEndDate() {
        return endDate;
    }

    @JsonProperty("end_date")
    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

}