package com.github.martinbennett.policeuk.api;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "url",
        "type",
        "description",
        "title"
})
public class EngagementMethod {

    @JsonProperty("url")
    private String url;
    @JsonProperty("type")
    private String type;
    @JsonProperty("description")
    private String description;
    @JsonProperty("title")
    private String title;

    @JsonProperty("url")
    public String getUrl() {
        return url;
    }

    @JsonProperty("url")
    public void setUrl(String url) {
        this.url = url;
    }

    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    @JsonProperty("type")
    public String getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    @JsonProperty("description")
    public void setDescription(String description) {
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

    @Override
    public String toString() {
        return "EngagementMethod{" +
                "url='" + url + '\'' +
                ", type='" + type + '\'' +
                ", description='" + description + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}