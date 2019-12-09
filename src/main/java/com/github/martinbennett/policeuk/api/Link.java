package com.github.martinbennett.policeuk.api;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "url",
        "description",
        "title"
})
public class Link {

    @JsonProperty("url")
    public String url;
    @JsonProperty("description")
    public Object description;
    @JsonProperty("title")
    public String title;

    @Override
    public String toString() {
        return "Link{" +
                "url='" + url + '\'' +
                ", description=" + description +
                ", title='" + title + '\'' +
                '}';
    }
}