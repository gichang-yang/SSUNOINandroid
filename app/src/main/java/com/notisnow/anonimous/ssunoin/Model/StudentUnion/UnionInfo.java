package com.notisnow.anonimous.ssunoin.Model.StudentUnion;

/**
 * Created by yang-gichang on 2017. 6. 30..
 */

public class UnionInfo {
    String slogun;
    String area;
    String facebookLink="";
    String call="";
    int  imgId;

    public UnionInfo(String slogun,String area, int imgId) {
        this.slogun = slogun;
        this.area=area;
        this.imgId = imgId;
    }

    public UnionInfo(String slogun, String area, String facebookLink, String call, int imgId) {
        this.slogun = slogun;
        this.area = area;
        this.facebookLink = facebookLink;
        this.call = call;
        this.imgId = imgId;
    }

    public String getFacebookLink() {
        return facebookLink;
    }

    public void setFacebookLink(String facebookLink) {
        this.facebookLink = facebookLink;
    }

    public String getCall() {
        return call;
    }

    public void setCall(String call) {
        this.call = call;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getSlogun() {
        return slogun;
    }

    public void setSlogun(String slogun) {
        this.slogun = slogun;
    }

    public int getImgId() {
        return imgId;
    }

    public void setImgId(int imgId) {
        this.imgId = imgId;
    }
}
