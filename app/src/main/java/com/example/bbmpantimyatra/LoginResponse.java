package com.example.bbmpantimyatra;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.zitlab.palmyra.annotation.MobyraType;

@MobyraType("cremStaff/userInfo")
public class LoginResponse {

    @SerializedName("loginName")
    @Expose
    private String loginName;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("mobileNumber")
    @Expose
    private Object mobileNumber;

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(Object mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

}
