package com.example.mylogin1;

import org.ksoap2.serialization.KvmSerializable;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;

import java.util.Date;

public class UserLogin {

    public static Class<UserLogin> USER_CLASS = UserLogin.class;
    public boolean _isAuthenticated = false;

    private String _Role = "";
    private String _UserName = "";
    private String _Password = "";
    private String _Designation = "";
    private String _PendingWorks = "";
    private Date _LastVisitedOn;
//    private String _Photo;
    private String _UserID = "";
    private String _IMEI = "";
//    private String _Userrole = "";
    private String _CircleID = "";
    private String _DivisionID = "";
    private String _DivisionName = "";
    private String CircleName = "";
    private String _WingID = "";
    private String _WingName = "";
    private String _ContactNo = "";
    private String _PackageId = "";
//    private String _PackageNm = "";

    public UserLogin(SoapObject obj) {
        this._isAuthenticated = Boolean.parseBoolean(obj.getProperty("isAuthenticated").toString());
        this._UserName = obj.getProperty("UserName").toString();
        this._IMEI = obj.getProperty("IMEI").toString();
        this._Designation = obj.getProperty("Desig").toString();
        this._PendingWorks = obj.getProperty("PendingWorks").toString();
        String LastVisit = obj.getProperty("LastVisitedOn").toString();
        String[] parts = LastVisit.split("T")[0].split("-");
        this._LastVisitedOn = new Date(Date.UTC(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]), Integer.parseInt(parts[2]), 0, 0, 0));
        this._Role = obj.getProperty("Role").toString();

        if (obj.getProperty("CircleID").toString().equalsIgnoreCase("anyType{}")){
            this._CircleID="";
        }
        else {
            this._CircleID = obj.getProperty("CircleID").toString();
        }

        if (obj.getProperty("CircleName").toString().equalsIgnoreCase("anyType{}")){
            this.CircleName="";
        }
        else {
            this.CircleName = obj.getProperty("CircleName").toString();
        }


        if (obj.getProperty("DivisionID").toString().equalsIgnoreCase("anyType{}")){
            this._DivisionID="";
        }
        else {
            this._DivisionID = obj.getProperty("DivisionID").toString();
        }


        if (obj.getProperty("DivisionName").toString().equalsIgnoreCase("anyType{}")){
            this._DivisionName="";
        }
        else {
            this._DivisionName = obj.getProperty("DivisionName").toString();
        }

        if (obj.getProperty("WingID").toString().equalsIgnoreCase("anyType{}")){
            this._WingID="";
        }
        else {
            this._WingID = obj.getProperty("WingID").toString();
        }

        if (obj.getProperty("WingName").toString().equalsIgnoreCase("anyType{}")){
            this._WingName="";
        }
        else {
            this._WingName = obj.getProperty("WingName").toString();
        }

        if (obj.getProperty("ContactNo").toString().equalsIgnoreCase("anyType{}")){
            this._ContactNo="";
        }
        else {
            this._ContactNo = obj.getProperty("ContactNo").toString();
        }

    }

    public void setAuthenticated(boolean _isAuthenticated) {
        this._isAuthenticated = _isAuthenticated;
    }

    public boolean getAuthenticated() {
        return _isAuthenticated;
    }

    public String get_Role() {
        return _Role;
    }

    public void set_Role(String _Role) {
        this._Role = _Role;
    }

    public String get_UserName() {
        return _UserName;
    }

    public void set_UserName(String _UserName) {
        this._UserName = _UserName;
    }

    public String get_Password() {
        return _Password;
    }

    public void set_Password(String _Password) {
        this._Password = _Password;
    }

    public String get_Designation() {
        return _Designation;
    }

    public void set_Designation(String _Designation) {
        this._Designation = _Designation;
    }

    public String get_PendingWorks() {
        return _PendingWorks;
    }

    public void set_PendingWorks(String _PendingWorks) {
        this._PendingWorks = _PendingWorks;
    }

    public Date get_LastVisitedOn() {
        return _LastVisitedOn;
    }

    public void set_LastVisitedOn(Date _LastVisitedOn) {
        this._LastVisitedOn = _LastVisitedOn;
    }

    public String get_UserID() {
        return _UserID;
    }

    public void set_UserID(String _UserID) {
        this._UserID = _UserID;
    }

    public String get_IMEI() {
        return _IMEI;
    }

    public void set_IMEI(String _IMEI) {
        this._IMEI = _IMEI;
    }

    public String get_CircleID() {
        return _CircleID;
    }

    public void set_CircleID(String _CircleID) {
        this._CircleID = _CircleID;
    }

    public String get_DivisionID() {
        return _DivisionID;
    }

    public void set_DivisionID(String _DivisionID) {
        this._DivisionID = _DivisionID;
    }

    public String get_DivisionName() {
        return _DivisionName;
    }

    public void set_DivisionName(String _DivisionName) {
        this._DivisionName = _DivisionName;
    }

    public String getCircleName() {
        return CircleName;
    }

    public void setCircleName(String circleName) {
        CircleName = circleName;
    }

    public String get_WingID() {
        return _WingID;
    }

    public void set_WingID(String _WingID) {
        this._WingID = _WingID;
    }

    public String get_WingName() {
        return _WingName;
    }

    public void set_WingName(String _WingName) {
        this._WingName = _WingName;
    }

    public String get_ContactNo() {
        return _ContactNo;
    }

    public void set_ContactNo(String _ContactNo) {
        this._ContactNo = _ContactNo;
    }

    public String get_PackageId() {
        return _PackageId;
    }

    public void set_PackageId(String _PackageId) {
        this._PackageId = _PackageId;
    }

}
