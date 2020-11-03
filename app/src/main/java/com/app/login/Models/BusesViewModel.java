package com.app.login.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class BusesViewModel implements Serializable {

    private String token;

    @SerializedName("tagIDs")
    @Expose
    private int tagIDs[];

    @SerializedName("applicationID")
    @Expose
    private int applicationID;

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("description")
    @Expose
    private String description;

    @SerializedName("matchAllTags")
    @Expose
    private String matchAllTags;

    @SerializedName("statusFilter")
    @Expose
    private String statusFilter;

    @SerializedName("id")
    @Expose
    private int id;

    public int[] getTagIDs() {
        return tagIDs;
    }

    public void setTagIDs(int[] tagIDs) {
        this.tagIDs = tagIDs;
    }

    public int getApplicationID() {
        return applicationID;
    }

    public void setApplicationID(int applicationID) {
        this.applicationID = applicationID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMatchAllTags() {
        return matchAllTags;
    }

    public void setMatchAllTags(String matchAllTags) {
        this.matchAllTags = matchAllTags;
    }

    public String getStatusFilter() {
        return statusFilter;
    }

    public void setStatusFilter(String statusFilter) {
        this.statusFilter = statusFilter;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
