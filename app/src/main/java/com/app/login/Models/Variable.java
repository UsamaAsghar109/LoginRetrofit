package com.app.login.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Variable {

    @SerializedName("name")
    @Expose
    private String  name;

    @SerializedName("type")
    @Expose
    private String  type;

    @SerializedName("time")
    @Expose
    private String time;

    @SerializedName("value")
    @Expose
    private String value;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
