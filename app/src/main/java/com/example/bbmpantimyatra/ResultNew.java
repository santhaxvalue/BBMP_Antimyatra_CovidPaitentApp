package com.example.bbmpantimyatra;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.zitlab.palmyra.annotation.MobyraType;

@MobyraType("cremStaff")
public class ResultNew {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("buSrfId")
    @Expose
    private String buSrfId;
    @SerializedName("address")
    @Expose
    private String address;
    @SerializedName("gender")
    @Expose
    private String gender;
    @SerializedName("religion")
    @Expose
    private String religion;
    @SerializedName("yearOfBirth")
    @Expose
    private String yearOfBirth;
    @SerializedName("zone")
    @Expose
    private String zone;
    @SerializedName("causeOfDeath")
    @Expose
    private String causeOfDeath;
    @SerializedName("placeOfDeath")
    @Expose
    private String placeOfDeath;
    @SerializedName("reportedBy")
    @Expose
    private String reportedBy;
    @SerializedName("reqStatus")
    @Expose
    private String reqStatus;
    @SerializedName("mobileNumber")
    @Expose
    private String mobileNumber;
    @SerializedName("mobileNumber2")
    @Expose
    private String mobileNumber2;
    @SerializedName("aadhaar")
    @Expose
    private String aadhaar;
    @SerializedName("crematoriumName")
    @Expose
    private String crematoriumName;
    @SerializedName("cremToken")
    @Expose
    private String cremToken;
    @SerializedName("cremDate")
    @Expose
    private String cremDate;

    @SerializedName("emailAddress")
    @Expose
    private String emailAddress;

    @SerializedName("timeSlot")
    @Expose
    private String timeSlot;
    @SerializedName("crematoriumCode")
    @Expose
    private String crematoriumCode;

    public String getBuSrfId() {
        return buSrfId;
    }

    public void setBuSrfId(String buSrfId) {
        this.buSrfId = buSrfId;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getReqStatus() {
        return reqStatus;
    }

    public void setReqStatus(String reqStatus) {
        this.reqStatus = reqStatus;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getReligion() {
        return religion;
    }

    public void setReligion(String religion) {
        this.religion = religion;
    }

    public String getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(String yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    public String getZone() {
        return zone;
    }

    public void setZone(String zone) {
        this.zone = zone;
    }

    public String getCauseOfDeath() {
        return causeOfDeath;
    }

    public void setCauseOfDeath(String causeOfDeath) {
        this.causeOfDeath = causeOfDeath;
    }

    public String getPlaceOfDeath() {
        return placeOfDeath;
    }

    public void setPlaceOfDeath(String placeOfDeath) {
        this.placeOfDeath = placeOfDeath;
    }

    public String getReportedBy() {
        return reportedBy;
    }

    public void setReportedBy(String reportedBy) {
        this.reportedBy = reportedBy;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getMobileNumber2() {
        return mobileNumber2;
    }

    public void setMobileNumber2(String mobileNumber2) {
        this.mobileNumber2 = mobileNumber2;
    }

    public String getAadhaar() {
        return aadhaar;
    }

    public void setAadhaar(String aadhaar) {
        this.aadhaar = aadhaar;
    }

    public String getCrematoriumName() {
        return crematoriumName;
    }

    public void setCrematoriumName(String crematoriumName) {
        this.crematoriumName = crematoriumName;
    }

    public String getCremToken() {
        return cremToken;
    }

    public void setCremToken(String cremToken) {
        this.cremToken = cremToken;
    }

    public String getCremDate() {
        return cremDate;
    }

    public void setCremDate(String cremDate) {
        this.cremDate = cremDate;
    }

    public String getTimeSlot() {
        return timeSlot;
    }

    public void setTimeSlot(String timeSlot) {
        this.timeSlot = timeSlot;
    }

    public String getCrematoriumCode() {
        return crematoriumCode;
    }

    public void setCrematoriumCode(String crematoriumCode) {
        this.crematoriumCode = crematoriumCode;
    }

}

