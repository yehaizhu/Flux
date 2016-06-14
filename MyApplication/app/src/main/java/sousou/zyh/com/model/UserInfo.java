package sousou.zyh.com.model;

import java.io.Serializable;

/**
 * Created by Administrator on 2015/12/9 0009.
 */
public class UserInfo implements Serializable{

    private String genTime;
    private String id;
    private String countyName;
    private String verifyCode;
    private String userPic;
    private String address;
    private String streetId;
    private String userId;
    private String userName;
    private String gender;
    private String streetName;
    private String mobileNo;
    private String genderStr;
    private String userType;
    private String password;

    public void setGenTime(String genTime) {
        this.genTime = genTime;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setCountyName(String countyName) {
        this.countyName = countyName;
    }

    public void setVerifyCode(String verifyCode) {
        this.verifyCode = verifyCode;
    }

    public void setUserPic(String userPic) {
        this.userPic = userPic;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setStreetId(String streetId) {
        this.streetId = streetId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public void setGenderStr(String genderStr) {
        this.genderStr = genderStr;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getGenTime() {
        return genTime;
    }

    public String getId() {
        return id;
    }

    public String getCountyName() {
        return countyName;
    }

    public String getVerifyCode() {
        return verifyCode;
    }

    public String getUserPic() {
        return userPic;
    }

    public String getAddress() {
        return address;
    }

    public String getStreetId() {
        return streetId;
    }

    public String getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public String getGender() {
        return gender;
    }

    public String getStreetName() {
        return streetName;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public String getGenderStr() {
        return genderStr;
    }

    public String getUserType() {
        return userType;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "{" +
                "genTime='" + genTime + '\'' +
                ", id='" + id + '\'' +
                ", countyName='" + countyName + '\'' +
                ", verifyCode='" + verifyCode + '\'' +
                ", userPic='" + userPic + '\'' +
                ", address='" + address + '\'' +
                ", streetId='" + streetId + '\'' +
                ", userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                ", gender='" + gender + '\'' +
                ", streetName='" + streetName + '\'' +
                ", mobileNo='" + mobileNo + '\'' +
                ", genderStr='" + genderStr + '\'' +
                ", userType='" + userType + '\'' +
                '}';
    }


}
