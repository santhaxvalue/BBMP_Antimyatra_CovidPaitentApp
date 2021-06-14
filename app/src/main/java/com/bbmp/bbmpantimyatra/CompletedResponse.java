package com.bbmp.bbmpantimyatra;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.zitlab.palmyra.annotation.MobyraType;

@MobyraType("cremStaff/complete")
public class CompletedResponse {

    @SerializedName("reqStatus")
    @Expose
    private String reqStatus;
    @SerializedName("crematedOn")
    @Expose
    private String crematedOn;
    @SerializedName("id")
    @Expose
    private Integer id;

    public String getReqStatus() {
        return reqStatus;
    }

    public void setReqStatus(String reqStatus) {
        this.reqStatus = reqStatus;
    }

    public String getCrematedOn() {
        return crematedOn;
    }

    public void setCrematedOn(String crematedOn) {
        this.crematedOn = crematedOn;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}
