package com.github.martinbennett.policeuk.api;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashMap;

/**
 * @author VenomousInc
 * @since 07/05/2019
 */
public class ContactDetails {

    @JsonIgnore
    private HashMap<String, String> contactProperty = new HashMap<>();

    @JsonAnyGetter
    public HashMap<String, String> getContactProperty() {
        return this.contactProperty;
    }

    @JsonAnySetter
    public void setContactProperty(String name, String value) {
        this.contactProperty.put(name, value);
    }

    @Override
    public String toString() {
        return "ContactDetails{" +
                "contactProperty=" + contactProperty +
                '}';
    }
}
