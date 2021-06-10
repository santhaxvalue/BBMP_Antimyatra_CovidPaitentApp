package com.example.bbmpantimyatra;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.zitlab.palmyra.annotation.MobyraType;

@MobyraType("cremStaff/reached")
public class ReachedResponse  {

    @SerializedName("reqStatus")
    @Expose
    private String reqStatus;
    @SerializedName("reachedOn")
    @Expose
    private String reachedOn;
    @SerializedName("id")
    @Expose
    private Integer id;

    public String getReqStatus() {
        return reqStatus;
    }

    public void setReqStatus(String reqStatus) {
        this.reqStatus = reqStatus;
    }

    public String getReachedOn() {
        return reachedOn;
    }

    public void setReachedOn(String reachedOn) {
        this.reachedOn = reachedOn;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}
