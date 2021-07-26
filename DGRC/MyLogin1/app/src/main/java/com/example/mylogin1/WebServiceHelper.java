package com.example.mylogin1;

import android.util.Base64;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mylogin1.MainActivity;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

import java.util.ArrayList;

//import in.nic.bih.oprmcmonitoring.entity.ChangePassword;
//import in.nic.bih.oprmcmonitoring.entity.CircleList;
//import in.nic.bih.oprmcmonitoring.entity.CompliancesListEntity;
//import in.nic.bih.oprmcmonitoring.entity.DivisionList;
//import in.nic.bih.oprmcmonitoring.entity.NewEntryEntity;
//import in.nic.bih.oprmcmonitoring.entity.PackageListEntity;
//import in.nic.bih.oprmcmonitoring.entity.Project_Name;
//import in.nic.bih.oprmcmonitoring.entity.RoadMaster;
//import in.nic.bih.oprmcmonitoring.entity.SubComponentsEntity;
//import in.nic.bih.oprmcmonitoring.entity.UploadedNonComplianceEntity;
//import in.nic.bih.oprmcmonitoring.entity.UserLogin;
//import in.nic.bih.oprmcmonitoring.entity.Versioninfo;
//import in.nic.bih.oprmcmonitoring.entity.WingList;


public class WebServiceHelper {
    //public static final String SERVICENAMESPACE = "http://10.133.20.150/";
    // public static final String SERVICENAMESPACE = "http://onlineapp.bih.nic.in/";
    public static final String SERVICENAMESPACE = "http://rcdonline.bih.nic.in/";

    //public static final String SERVICEURL = "http://onlineapp.bih.nic.in/OPRMCLABApp.asmx";
    public static final String SERVICEURL = "http://rcdonline.bih.nic.in/OPRMCLABApp.asmx";
    public static final String AUTHENTICATE_METHOD = "Authenticate";
    public static final String APPVERSION_METHOD = "getAppLatest";
    public static final String WINGLIST_METHOD = "getWing";
    public static final String CIRCLE_METHOD = "getCircles";
    public static final String DEVISIONLIST_METHOD = "getDivisions";
    public static final String ROADMASTER = "getAllRoadMaster";
    public static final String CHAINGAETYPE = "getRoadlength";
//    public static final String CHANGESUBTYPE = "getAllRoadMaster";
//    public static final String InsertCMBDData = "InsertCMBDData";
//    public static final String InsertOPRMCData = "InsertOPRMCData";
//    public static final String InsertSBDData = "InsertSBDData";
//    public static final String InsertotherData = "InsertotherData";
    public static final String GETPROJECTLIST = "getAllProjectMaster";
    public static final String GET_Division_LIST = "getDivisions";
    public static final String GET_Compliance_LIST = "ListNonCompliance";
    public static final String GET_Component_LIST = "getSubComponentNCompliance";
    public static final String GET_Package_LIST = "getPackagelist";
    public static final String GET_Road_LIST = "getRoadLists";
    public static final String ChangePASSWORD = "ChangeThisPassword";
    public static final String INSERT_QC_details = "InsertQCLabMonitoringData";
    public static final String INSERT_OPRMC_details = "InsertNonComplianceData";
    public static final String getNonComplianceData = "getNonComplianceData";
    public static final String Upload_Compliance_Data = "SetComplianceData";

    static String rest;

    // User login GET - POST from web
    public static UserLogin Login(String User_ID, String Pwd)
    {
        try
        {
            SoapObject request = new SoapObject(SERVICENAMESPACE, AUTHENTICATE_METHOD);

            request.addProperty("UserID", User_ID);
            request.addProperty("Password", Pwd);
            SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
            envelope.dotNet = true;
            envelope.setOutputSoapObject(request);
            envelope.addMapping(SERVICENAMESPACE,UserLogin.USER_CLASS.getSimpleName(), UserLogin.USER_CLASS);
            HttpTransportSE androidHttpTransport = new HttpTransportSE(SERVICEURL);
            androidHttpTransport.call(SERVICENAMESPACE + AUTHENTICATE_METHOD,envelope);

            Object result = (Object) envelope.getResponse();
            if (result != null)
                return new UserLogin((SoapObject) result);
            else
                return null;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }

//    public static Versioninfo CheckVersion(String version) {
//        Versioninfo versioninfo;
//        SoapObject res1;
//        try {
//
//            res1=getServerData(APPVERSION_METHOD,Versioninfo.Versioninfo_CLASS,"IMEI","Ver","0",version);
//            SoapObject final_object = (SoapObject) res1.getProperty(0);
//
//            versioninfo = new Versioninfo(final_object);
//
//        } catch (Exception e) {
//
//            return null;
//        }
//        return versioninfo;
//
//    }


//    public static SoapObject getServerData(String methodName, Class bindClass, String param1, String param2, String value1, String value2 )
//    {
//        SoapObject res1;
//        try {
//            SoapObject request = new SoapObject(SERVICENAMESPACE,methodName);
//            request.addProperty(param1,value1);
//            request.addProperty(param2,value2);
//            SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
//            envelope.dotNet = true;
//            envelope.setOutputSoapObject(request);
//            envelope.addMapping(SERVICENAMESPACE,bindClass.getSimpleName(),bindClass);
//            HttpTransportSE androidHttpTransport = new HttpTransportSE(SERVICEURL);
//            androidHttpTransport.call(SERVICENAMESPACE + methodName,envelope);
//            res1 = (SoapObject) envelope.getResponse();
//        } catch (Exception e) {
//            e.printStackTrace();
//            return null;
//        }
//        return res1;
//    }
//
//    public static SoapObject getServerData(String methodName, Class bindClass)
//    {
//        SoapObject res1;
//        try {
//            SoapObject request = new SoapObject(SERVICENAMESPACE,methodName);
//            SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
//            envelope.dotNet = true;
//            envelope.setOutputSoapObject(request);
//            envelope.addMapping(SERVICENAMESPACE,bindClass.getSimpleName(),bindClass);
//            HttpTransportSE androidHttpTransport = new HttpTransportSE(SERVICEURL);
//            androidHttpTransport.call(SERVICENAMESPACE + methodName,envelope);
//            res1 = (SoapObject) envelope.getResponse();
//        } catch (Exception e) {
//            e.printStackTrace();
//            return null;
//        }
//        return res1;
//    }
//
//    public static Versioninfo CheckVersion(String version) {
//
//        SoapObject request = new SoapObject(SERVICENAMESPACE, APPVERSION_METHOD);
//
//        request.addProperty("IMEI", "");
//        request.addProperty("Ver", version);
//        Versioninfo versioninfo;
//        SoapObject res1;
//        try {
//            SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
//            envelope.dotNet = true;
//            envelope.setOutputSoapObject(request);
//            envelope.addMapping(SERVICENAMESPACE, Versioninfo.Versioninfo_CLASS.getSimpleName(), Versioninfo.Versioninfo_CLASS);
//            HttpTransportSE androidHttpTransport = new HttpTransportSE(SERVICEURL);
//            androidHttpTransport.call(SERVICENAMESPACE + APPVERSION_METHOD, envelope);
//
//            res1 = (SoapObject) envelope.getResponse();
//
//            int TotalProperty = res1.getPropertyCount();
//
//            // Object property = res1.getProperty(0);
//            SoapObject final_object = (SoapObject) res1.getProperty(0);
//            versioninfo = new Versioninfo(final_object);
//
//        } catch (Exception e) {
//
//            return null;
//        }
//        return versioninfo;
//
//    }

//    public static String change_Password(ChangePassword chng, String Uid) {
//        try {
//            SoapObject request = new SoapObject(SERVICENAMESPACE,ChangePASSWORD);
//            request.addProperty("_UserID",Uid);
//            request.addProperty("_OldPwd",chng.getChangepass_old());
//            request.addProperty("_NewPwd",chng.getChangepass_confirm());
//
//            SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
//                    SoapEnvelope.VER11);
//            envelope.dotNet = true;
//            envelope.setOutputSoapObject(request);
//            envelope.addMapping(SERVICENAMESPACE,
//                    ChangePassword.ChangePassword_CLASS.getSimpleName(),
//                    ChangePassword.ChangePassword_CLASS);
//            HttpTransportSE androidHttpTransport = new HttpTransportSE(
//                    SERVICEURL);
//            androidHttpTransport.call(SERVICENAMESPACE + ChangePASSWORD,
//                    envelope);
//
//            Object result = envelope.getResponse();
//
//            if (result != null) {
//                // Log.d("", result.toString());
//
//                return result.toString();
//            } else
//                return null;
//
//        } catch (Exception e) {
//            e.printStackTrace();
//            return null;
//        }
//
//    }

    //    public static ArrayList<WingList> getWingList() {
//        SoapObject res1;
//        res1=getServerData(WINGLIST_METHOD,WingList.WING_LIST);
//        int TotalProperty=0;
//        if(res1!=null) TotalProperty= res1.getPropertyCount();
//        ArrayList<WingList> fieldList = new ArrayList<WingList>();
//
//        for (int i = 0; i < TotalProperty; i++) {
//            if (res1.getProperty(i) != null) {
//                Object property = res1.getProperty(i);
//                if (property instanceof SoapObject) {
//                    SoapObject final_object = (SoapObject) property;
//                    WingList fieldInformation = new WingList(final_object);
//                    fieldList.add(fieldInformation);
//                }
//            } else
//                return fieldList;
//        }
//
//        return fieldList;
//    }
//    public static ArrayList<CircleList> getCircleList() {
//        SoapObject res1;
//        res1=getServerData(CIRCLE_METHOD,CircleList.CIRCLE_LIST);
//        int TotalProperty=0;
//        if(res1!=null) TotalProperty= res1.getPropertyCount();
//        ArrayList<CircleList> fieldList = new ArrayList<CircleList>();
//
//        for (int i = 0; i < TotalProperty; i++) {
//            if (res1.getProperty(i) != null) {
//                Object property = res1.getProperty(i);
//                if (property instanceof SoapObject) {
//                    SoapObject final_object = (SoapObject) property;
//                    CircleList fieldInformation = new CircleList(final_object);
//                    fieldList.add(fieldInformation);
//                }
//            } else
//                return fieldList;
//        }
//
//        return fieldList;
//    }
//
//    public static ArrayList<DivisionList> getDevisionList() {
//        SoapObject res1;
//        res1=getServerData(DEVISIONLIST_METHOD,DivisionList.DIVISION_LIST);
//        int TotalProperty=0;
//        if(res1!=null) TotalProperty= res1.getPropertyCount();
//        ArrayList<DivisionList> fieldList = new ArrayList<DivisionList>();
//
//        for (int i = 0; i < TotalProperty; i++) {
//            if (res1.getProperty(i) != null) {
//                Object property = res1.getProperty(i);
//                if (property instanceof SoapObject) {
//                    SoapObject final_object = (SoapObject) property;
//                    DivisionList fieldInformation = new DivisionList(final_object);
//                    fieldList.add(fieldInformation);
//                }
//            } else
//                return fieldList;
//        }
//
//        return fieldList;
//    }

//    public static ArrayList<RoadMaster> getReportData(String DivId)
//    {
//
//        SoapObject res1;
//        try
//        {
//            SoapObject request = new SoapObject(SERVICENAMESPACE, ROADMASTER);
//            request.addProperty("DivId",DivId);
//
//            SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
//            envelope.dotNet = true;
//            envelope.setOutputSoapObject(request);
//            envelope.addMapping(SERVICENAMESPACE, RoadMaster.ReportEntity_CLASS.getSimpleName(), RoadMaster.ReportEntity_CLASS);
//            HttpTransportSE androidHttpTransport = new HttpTransportSE(SERVICEURL);
//            androidHttpTransport.call(SERVICENAMESPACE + ROADMASTER, envelope);
//
//            res1 = (SoapObject) envelope.getResponse();
//
//        }
//        catch (Exception e)
//        {
//            e.printStackTrace();
//            return null;
//        }
//
//        int TotalProperty=0;
//        if(res1!=null) TotalProperty= res1.getPropertyCount();
//
//        ArrayList<RoadMaster> fieldList = new ArrayList<RoadMaster>();
//
//        for (int i = 0; i < TotalProperty; i++)
//        {
//            if (res1.getProperty(i) != null)
//            {
//                Object property = res1.getProperty(i);
//                if (property instanceof SoapObject)
//                {
//                    SoapObject final_object = (SoapObject) property;
//                    RoadMaster report= new RoadMaster(final_object);
//                    fieldList.add(report);
//                }
//            }
//            else{
//                return fieldList;
//            }
//
//        }
//
//        return fieldList;
//    }
//
//
//    public static ArrayList<RoadMaster> getChaingaeType(String RoadId)
//    {
//
//        SoapObject res1;
//        try
//        {
//            SoapObject request = new SoapObject(SERVICENAMESPACE, CHAINGAETYPE);
//            request.addProperty("Roadid",RoadId);
//
//            SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
//                    SoapEnvelope.VER11);
//            envelope.dotNet = true;
//            envelope.setOutputSoapObject(request);
//            envelope.addMapping(SERVICENAMESPACE, RoadMaster.ReportEntity_CLASS.getSimpleName(), RoadMaster.ReportEntity_CLASS);
//            HttpTransportSE androidHttpTransport = new HttpTransportSE(SERVICEURL);
//            androidHttpTransport.call(SERVICENAMESPACE + CHAINGAETYPE, envelope);
//
//            res1 = (SoapObject) envelope.getResponse();
//
//        }
//        catch (Exception e)
//        {
//            e.printStackTrace();
//            return null;
//        }
//
//        int TotalProperty=0;
//        if(res1!=null) TotalProperty= res1.getPropertyCount();
//
//        ArrayList<RoadMaster> fieldList = new ArrayList<RoadMaster>();
//
//        for (int i = 0; i < TotalProperty; i++)
//        {
//            if (res1.getProperty(i) != null)
//            {
//                Object property = res1.getProperty(i);
//                if (property instanceof SoapObject)
//                {
//                    SoapObject final_object = (SoapObject) property;
//                    RoadMaster report= new RoadMaster(final_object,1);
//                    fieldList.add(report);
//                }
//            }
//            else
//            {
//                return fieldList;
//            }
//
//        }
//
//        return fieldList;
//    }
//
//    public static ArrayList<Project_Name> getProjectListLocal(String div_id,String cir_id) {
//
//
//        SoapObject request = new SoapObject(SERVICENAMESPACE, GETPROJECTLIST);
//        request.addProperty("DivId", div_id);
//        request.addProperty("CirID", cir_id);
//
//        SoapObject res1;
//        try {
//
//            SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
//            envelope.dotNet = true;
//            envelope.setOutputSoapObject(request);
//            envelope.addMapping(SERVICENAMESPACE, Project_Name.Project_Name_CLASS.getSimpleName(), Project_Name.Project_Name_CLASS);
//
//            HttpTransportSE androidHttpTransport = new HttpTransportSE(SERVICEURL);
//            androidHttpTransport.call(SERVICENAMESPACE + GETPROJECTLIST, envelope);
//
//            res1 = (SoapObject) envelope.getResponse();
//
//        } catch (Exception e) {
//            e.printStackTrace();
//            return null;
//        }
//        int TotalProperty = res1.getPropertyCount();
//        ArrayList<Project_Name> pvmArrayList = new ArrayList<Project_Name>();
//        if (TotalProperty > 0) {
//
//
//            for (int ii = 0; ii < TotalProperty; ii++) {
//                if (res1.getProperty(ii) != null) {
//                    Object property = res1.getProperty(ii);
//                    if (property instanceof SoapObject) {
//                        SoapObject final_object = (SoapObject) property;
//                        Project_Name state = new Project_Name(final_object);
//                        pvmArrayList.add(state);
//                    }
//                } else
//                    return pvmArrayList;
//            }
//        }
//
//
//        return pvmArrayList;
//    }



    //    public static String UploadSingleData(FillQC_Report data, String devicename, String App_ver,String uid) {
//    public static String UploadSingleData(NewEntryEntity data, String deviceid, String App_ver, String uid,String wing,String circle,String name,String desig) {
//
//        SoapObject request = new SoapObject(SERVICENAMESPACE, INSERT_OPRMC_details);
//        request.addProperty("_DivisionId", data.getDiv_Id());
//        request.addProperty("_PackageId", data.getPackage_Id());
//        request.addProperty("_Roadname", data.getRoad_Id());
//        request.addProperty("_Kilometer", data.get_kilometers());
//        request.addProperty("_NonComplianceId",data.get_compliance_id());
//        request.addProperty("_NonSubComponent",data.get_component_id());
//        // request.addProperty("_Image1",data.getPhoto1());
//        if(data.getPhoto1()== null){
//            request.addProperty("_Image1", "");
//        }else {
//            request.addProperty("_Image1", Base64.encodeToString(data.getPhoto1(),Base64.NO_WRAP));
//        }
//
//        if(data.getPhoto2()== null){
//            request.addProperty("_Image2", "");
//        }else {
//            request.addProperty("_Image2", Base64.encodeToString(data.getPhoto2(),Base64.NO_WRAP));
//        }
//        // request.addProperty("_Image2", data.getPhoto2());
//        // request.addProperty("_Image2",Base64.encodeToString(data.getPhoto2(),Base64.NO_WRAP));
//        request.addProperty("_Latitude", data.get_Latitude());
//        request.addProperty("_Longitude", data.get_Longitude());
//        request.addProperty("_DeviceId", deviceid);
//        request.addProperty("_AppVersion", App_ver);
//        request.addProperty("_Userid", uid);
//        request.addProperty("_wingid", wing);
//        request.addProperty("_circleid", circle);
//        request.addProperty("_EngineerName", name);
//        request.addProperty("_Designation", desig);
//        request.addProperty("_InspectionDate", data.get_entry_date());
//
//
//
//
//        try {
//            SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
//            envelope.dotNet = true;
//            envelope.implicitTypes = true;
//            envelope.setOutputSoapObject(request);
//
//            HttpTransportSE androidHttpTransport = new HttpTransportSE(SERVICEURL);
//            androidHttpTransport.call(SERVICENAMESPACE + INSERT_OPRMC_details, envelope);
//
//            rest = envelope.getResponse().toString();
//
//        }
//        catch (Exception e) {
//            e.printStackTrace();
//            return "0";
//        }
//        return rest;
//
//    }
//
//
//    public static ArrayList<DivisionList> getDivisionListLocal() {
//
//
//        SoapObject request = new SoapObject(SERVICENAMESPACE, GET_Division_LIST);
//
//
//        SoapObject res1;
//        try {
//
//            SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
//            envelope.dotNet = true;
//            envelope.setOutputSoapObject(request);
//            envelope.addMapping(SERVICENAMESPACE, DivisionList.DIVISION_LIST.getSimpleName(), DivisionList.DIVISION_LIST);
//
//            HttpTransportSE androidHttpTransport = new HttpTransportSE(SERVICEURL);
//            androidHttpTransport.call(SERVICENAMESPACE + GET_Division_LIST, envelope);
//
//            res1 = (SoapObject) envelope.getResponse();
//
//        } catch (Exception e) {
//            e.printStackTrace();
//            return null;
//        }
//        int TotalProperty = res1.getPropertyCount();
//        ArrayList<DivisionList> pvmArrayList = new ArrayList<DivisionList>();
//        if (TotalProperty > 0) {
//
//
//            for (int ii = 0; ii < TotalProperty; ii++) {
//                if (res1.getProperty(ii) != null) {
//                    Object property = res1.getProperty(ii);
//                    if (property instanceof SoapObject) {
//                        SoapObject final_object = (SoapObject) property;
//                        DivisionList state = new DivisionList(final_object);
//                        pvmArrayList.add(state);
//                    }
//                } else
//                    return pvmArrayList;
//            }
//        }
//
//
//        return pvmArrayList;
//    }
//
//
//    public static ArrayList<CompliancesListEntity> getCompliancesListLocal() {
//
//
//        SoapObject request = new SoapObject(SERVICENAMESPACE, GET_Compliance_LIST);
//
//
//        SoapObject res1;
//        try {
//
//            SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
//            envelope.dotNet = true;
//            envelope.setOutputSoapObject(request);
//            envelope.addMapping(SERVICENAMESPACE, CompliancesListEntity.Compliance_LIST.getSimpleName(), CompliancesListEntity.Compliance_LIST);
//
//            HttpTransportSE androidHttpTransport = new HttpTransportSE(SERVICEURL);
//            androidHttpTransport.call(SERVICENAMESPACE + GET_Compliance_LIST, envelope);
//
//            res1 = (SoapObject) envelope.getResponse();
//
//        } catch (Exception e) {
//            e.printStackTrace();
//            return null;
//        }
//        int TotalProperty = res1.getPropertyCount();
//        ArrayList<CompliancesListEntity> pvmArrayList = new ArrayList<CompliancesListEntity>();
//        if (TotalProperty > 0) {
//
//
//            for (int ii = 0; ii < TotalProperty; ii++) {
//                if (res1.getProperty(ii) != null) {
//                    Object property = res1.getProperty(ii);
//                    if (property instanceof SoapObject) {
//                        SoapObject final_object = (SoapObject) property;
//                        CompliancesListEntity state = new CompliancesListEntity(final_object);
//                        pvmArrayList.add(state);
//                    }
//                } else
//                    return pvmArrayList;
//            }
//        }
//
//
//        return pvmArrayList;
//    }
//
//
//    public static ArrayList<PackageListEntity> getPackageListLocal(String divid) {
//
//
//        SoapObject request = new SoapObject(SERVICENAMESPACE, GET_Package_LIST);
//        request.addProperty("divisionid",divid);
//
//        SoapObject res1;
//        try {
//
//            SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
//            envelope.dotNet = true;
//            envelope.setOutputSoapObject(request);
//            envelope.addMapping(SERVICENAMESPACE, PackageListEntity.Package_LIST.getSimpleName(), PackageListEntity.Package_LIST);
//
//            HttpTransportSE androidHttpTransport = new HttpTransportSE(SERVICEURL);
//            androidHttpTransport.call(SERVICENAMESPACE + GET_Package_LIST, envelope);
//
//            res1 = (SoapObject) envelope.getResponse();
//
//        } catch (Exception e) {
//            e.printStackTrace();
//            return null;
//        }
//        int TotalProperty = res1.getPropertyCount();
//        ArrayList<PackageListEntity> pvmArrayList = new ArrayList<PackageListEntity>();
//        if (TotalProperty > 0) {
//
//
//            for (int ii = 0; ii < TotalProperty; ii++) {
//                if (res1.getProperty(ii) != null) {
//                    Object property = res1.getProperty(ii);
//                    if (property instanceof SoapObject) {
//                        SoapObject final_object = (SoapObject) property;
//                        PackageListEntity state = new PackageListEntity(final_object);
//                        pvmArrayList.add(state);
//                    }
//                } else
//                    return pvmArrayList;
//            }
//        }
//
//
//        return pvmArrayList;
//    }
//
//
//    public static ArrayList<RoadMaster> getRoadLocal(String pckg) {
//
//
//        SoapObject request = new SoapObject(SERVICENAMESPACE, GET_Road_LIST);
//        request.addProperty("packageid",pckg);
//
//        SoapObject res1;
//        try {
//
//            SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
//            envelope.dotNet = true;
//            envelope.setOutputSoapObject(request);
//            envelope.addMapping(SERVICENAMESPACE, RoadMaster.ReportEntity_CLASS.getSimpleName(), RoadMaster.ReportEntity_CLASS);
//
//            HttpTransportSE androidHttpTransport = new HttpTransportSE(SERVICEURL);
//            androidHttpTransport.call(SERVICENAMESPACE + GET_Road_LIST, envelope);
//
//            res1 = (SoapObject) envelope.getResponse();
//
//        } catch (Exception e) {
//            e.printStackTrace();
//            return null;
//        }
//        int TotalProperty = res1.getPropertyCount();
//        ArrayList<RoadMaster> pvmArrayList = new ArrayList<RoadMaster>();
//        if (TotalProperty > 0) {
//
//
//            for (int ii = 0; ii < TotalProperty; ii++) {
//                if (res1.getProperty(ii) != null) {
//                    Object property = res1.getProperty(ii);
//                    if (property instanceof SoapObject) {
//                        SoapObject final_object = (SoapObject) property;
//                        RoadMaster state = new RoadMaster(final_object);
//                        pvmArrayList.add(state);
//                    }
//                } else
//                    return pvmArrayList;
//            }
//        }
//
//
//        return pvmArrayList;
//    }
//
//
//
//    public static ArrayList<SubComponentsEntity> getSubComponentsListLocal() {
//
//
//        SoapObject request = new SoapObject(SERVICENAMESPACE, GET_Component_LIST);
//
//
//        SoapObject res1;
//        try {
//
//            SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
//            envelope.dotNet = true;
//            envelope.setOutputSoapObject(request);
//            envelope.addMapping(SERVICENAMESPACE, SubComponentsEntity.SubComponents_LIST.getSimpleName(), SubComponentsEntity.SubComponents_LIST);
//
//            HttpTransportSE androidHttpTransport = new HttpTransportSE(SERVICEURL);
//            androidHttpTransport.call(SERVICENAMESPACE + GET_Component_LIST, envelope);
//
//            res1 = (SoapObject) envelope.getResponse();
//
//        } catch (Exception e) {
//            e.printStackTrace();
//            return null;
//        }
//        int TotalProperty = res1.getPropertyCount();
//        ArrayList<SubComponentsEntity> pvmArrayList = new ArrayList<SubComponentsEntity>();
//        if (TotalProperty > 0) {
//
//
//            for (int ii = 0; ii < TotalProperty; ii++) {
//                if (res1.getProperty(ii) != null) {
//                    Object property = res1.getProperty(ii);
//                    if (property instanceof SoapObject) {
//                        SoapObject final_object = (SoapObject) property;
//                        SubComponentsEntity state = new SubComponentsEntity(final_object);
//                        pvmArrayList.add(state);
//                    }
//                } else
//                    return pvmArrayList;
//            }
//        }
//
//
//        return pvmArrayList;
//    }
//
//
//    public static ArrayList<UploadedNonComplianceEntity> getNonComplianceDetailsData(String userid, String divid) {
//
//
//        SoapObject request = new SoapObject(SERVICENAMESPACE, getNonComplianceData);
//        request.addProperty("_userid",userid);
//        request.addProperty("_DivisionID",divid);
//
//        SoapObject res1;
//        try {
//
//            SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
//            envelope.dotNet = true;
//            envelope.setOutputSoapObject(request);
//            envelope.addMapping(SERVICENAMESPACE, UploadedNonComplianceEntity.UploadedNonCompliance_LIST.getSimpleName(), UploadedNonComplianceEntity.UploadedNonCompliance_LIST);
//
//            HttpTransportSE androidHttpTransport = new HttpTransportSE(SERVICEURL);
//            androidHttpTransport.call(SERVICENAMESPACE + getNonComplianceData, envelope);
//
//            res1 = (SoapObject) envelope.getResponse();
//
//        } catch (Exception e) {
//            e.printStackTrace();
//            return null;
//        }
//        int TotalProperty = res1.getPropertyCount();
//        ArrayList<UploadedNonComplianceEntity> pvmArrayList = new ArrayList<UploadedNonComplianceEntity>();
//        if (TotalProperty > 0) {
//
//
//            for (int ii = 0; ii < TotalProperty; ii++) {
//                if (res1.getProperty(ii) != null) {
//                    Object property = res1.getProperty(ii);
//                    if (property instanceof SoapObject) {
//                        SoapObject final_object = (SoapObject) property;
//                        UploadedNonComplianceEntity state = new UploadedNonComplianceEntity(final_object);
//                        pvmArrayList.add(state);
//                    }
//                } else
//                    return pvmArrayList;
//            }
//        }
//
//
//        return pvmArrayList;
//    }
//
//
//    public static String UploadSingleComplianceData(UploadedNonComplianceEntity data, String deviceid, String App_ver, String uid,String wing,String circle,String name,String desig) {
//
//        SoapObject request = new SoapObject(SERVICENAMESPACE, Upload_Compliance_Data);
//        request.addProperty("_RecordID", data.getComplianceRecordID());
//        request.addProperty("_DivisionId", data.getDivisionID());
//        request.addProperty("_PackageId", data.getPackageId());
//        request.addProperty("_Roadname", data.getROADid());
//        request.addProperty("_Kilometer",data.getInsKilometer());
//        request.addProperty("_NonComplianceId",data.getNonComplianceId());
//        request.addProperty("_SubComponent",data.getSubComponentID());
//        // request.addProperty("_Image1",data.getPhoto1());
//        if(data.getPhoto1()== null){
//            request.addProperty("_Image3", "");
//        }else {
//            request.addProperty("_Image3", Base64.encodeToString(data.getPhoto1(),Base64.NO_WRAP));
//        }
//
//        if(data.getPhoto2()== null){
//            request.addProperty("_Image4", "");
//        }else {
//            request.addProperty("_Image4", Base64.encodeToString(data.getPhoto2(),Base64.NO_WRAP));
//        }
//        // request.addProperty("_Image2", data.getPhoto2());
//        // request.addProperty("_Image2",Base64.encodeToString(data.getPhoto2(),Base64.NO_WRAP));
//        request.addProperty("_Latitude", data.getLatitude());
//        request.addProperty("_Longitude", data.getLongitude());
//        request.addProperty("_DeviceId", deviceid);
//        request.addProperty("_AppVersion", App_ver);
//        request.addProperty("_Userid", uid);
//        request.addProperty("_wingid", wing);
//        request.addProperty("_circleid", circle);
//        request.addProperty("_EngineerName", name);
//        request.addProperty("_Designation", desig);
//        request.addProperty("_InspectionDate", data.getEntry_date());
//        request.addProperty("_uploadStatus", "Y");
//
//
//
//
//        try {
//            SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
//            envelope.dotNet = true;
//            envelope.implicitTypes = true;
//            envelope.setOutputSoapObject(request);
//
//            HttpTransportSE androidHttpTransport = new HttpTransportSE(SERVICEURL);
//            androidHttpTransport.call(SERVICENAMESPACE + Upload_Compliance_Data, envelope);
//
//            rest = envelope.getResponse().toString();
//
//        }
//        catch (Exception e) {
//            e.printStackTrace();
//            return "0";
//        }
//        return rest;
//
//    }


}
