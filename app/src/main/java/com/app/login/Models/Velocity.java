package com.app.login.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Velocity {
    @SerializedName("groundSpeed")
    @Expose
    private int groundSpeed;

    @SerializedName("heading")
    @Expose
    private int heading;

    public int getGroundSpeed() {
        return groundSpeed;
    }

    public void setGroundSpeed(int groundSpeed) {
        this.groundSpeed = groundSpeed;
    }

    public int getHeading() {
        return heading;
    }

    public void setHeading(int heading) {
        this.heading = heading;
    }
}
