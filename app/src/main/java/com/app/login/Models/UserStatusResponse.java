package com.app.login.Models;

import android.widget.TextView;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UserStatusResponse {

    private String token;

    @SerializedName("position")
    @Expose
    private Position position;

    @SerializedName("utc")
    @Expose
    private String utc;

    @SerializedName("velocity")
    @Expose
    private Velocity velocity;

    @SerializedName("variables")
    @Expose
    private Variable variables;

    @SerializedName("username")
    @Expose
    private String username;

    @SerializedName("id")
    @Expose
    private int id;

//    public UserStatusResponse(String token, Position position, String utc, Velocity velocity, Variable variables, String username, int id) {
//        this.token = token;
//        this.position = position;
//        this.utc = utc;
//        this.velocity = velocity;
//        this.variables = variables;
//        this.username = username;
//        this.id = id;
//    }

    public UserStatusResponse(TextView position, TextView utc, TextView velocity, TextView variables, TextView username, TextView id, String token) {
        this.token = token;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public String getUtc() {
        return utc;
    }

    public void setUtc(String utc) {
        this.utc = utc;
    }

    public Velocity getVelocity() {
        return velocity;
    }

    public void setVelocity(Velocity velocity) {
        this.velocity = velocity;
    }

    public Variable getVariables() {
        return variables;
    }

    public void setVariables(Variable variables) {
        this.variables = variables;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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
