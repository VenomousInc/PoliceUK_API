package com.github.venomousinc.policeuk.api;

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
    public String description;
    @JsonProperty("title")
    public String title;

    public String toPrettyPrint() {
        return String.format(
                "# Link #%n url: %s%n description: %s%n title: %s", this.url, this.description, this.title);
    }

    @Override
    public String toString() {
        return "Link{" +
                "url='" + url + '\'' +
                ", description=" + description +
                ", title='" + title + '\'' +
                '}';
    }
}