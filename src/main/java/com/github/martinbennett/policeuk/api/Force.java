package com.github.martinbennett.policeuk.api;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.ArrayList;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "description",
        "url",
        "engagement_methods",
        "telephone",
        "id",
        "name"
})
public class Force {

    @JsonProperty("description")
    private String description = null;
    @JsonProperty("url")
    private String url = null;
    @JsonProperty("engagement_methods")
    private List<EngagementMethod> engagementMethods = new ArrayList<>();
    @JsonProperty("telephone")
    private String telephone = null;
    @JsonProperty("id")
    private String id = null;
    @JsonProperty("name")
    private String name = null;

    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    @JsonProperty("url")
    public String getUrl() {
        return url;
    }

    @JsonProperty("url")
    public void setUrl(String url) {
        this.url = url;
    }

    @JsonProperty("engagement_methods")
    public List<EngagementMethod> getEngagementMethods() {
        return engagementMethods;
    }

    @JsonProperty("engagement_methods")
    public void setEngagementMethods(List<EngagementMethod> engagementMethods) {
        this.engagementMethods = engagementMethods;
    }

    @JsonProperty("telephone")
    public String getTelephone() {
        return telephone;
    }

    @JsonProperty("telephone")
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Force{" +
                "description='" + description + '\'' +
                ", url='" + url + '\'' +
                ", engagementMethods=" + engagementMethods +
                ", telephone='" + telephone + '\'' +
                ", id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}