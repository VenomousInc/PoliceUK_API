package com.github.venomousinc.policeuk.api.neighbourhood;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "action",
        "issue-date",
        "action-date",
        "issue"
})
public class Priority {

    @JsonProperty("action")
    private String action;
    @JsonProperty("issue-date")
    private String issueDate;
    @JsonProperty("action-date")
    private String actionDate;
    @JsonProperty("issue")
    private String issue;

    @JsonProperty("action")
    public String getAction() {
        return action;
    }

    @JsonProperty("action")
    public void setAction(String action) {
        this.action = action;
    }

    @JsonProperty("issue-date")
    public String getIssueDate() {
        return issueDate;
    }

    @JsonProperty("issue-date")
    public void setIssueDate(String issueDate) {
        this.issueDate = issueDate;
    }

    @JsonProperty("action-date")
    public String getActionDate() {
        return actionDate;
    }

    @JsonProperty("action-date")
    public void setActionDate(String actionDate) {
        this.actionDate = actionDate;
    }

    @JsonProperty("issue")
    public String getIssue() {
        return issue;
    }

    @JsonProperty("issue")
    public void setIssue(String issue) {
        this.issue = issue;
    }

    public String toPrettyPrint() {
        return String.format(
                "# Priorities #" +
                        "%n action: %s" +
                        "%n issueDate: %s" +
                        "%n actionDate: %s" +
                        "%n issue: %s", this.action, this.issueDate, this.actionDate, this.issue);
    }

    @Override
    public String toString() {
        return "Priorities{" +
                "action=" + action +
                ", issueDate='" + issueDate + '\'' +
                ", actionDate=" + actionDate +
                ", issue='" + issue + '\'' +
                '}';
    }
}