package com.example.rahulmedhasoft.database;


import com.example.rahulmedhasoft.entity.StudentInfo;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

import java.util.ArrayList;

public class WebServiceHelper {


//  public static final String SERVICENAMESPACE = "http://schoolwebservice:8080/";
    public static final String SERVICENAMESPACE = "http://10.133.20.135:4545/";
//public static final String SERVICENAMESPACE = "http://192.168.43.191:4545/";
    public static final String SERVICEURL = "http://10.133.20.135:4545/WebServiceAPI.asmx";
//public static final String SERVICEURL = "http://192.168.43.191:4545/WebServiceAPI.asmx";
    //    public static final String SERVICEURL = "http://10.133.20.135:8081/WebServiceAPI.asmx";
    public static final String AuthenticateMethod = "Authenticate";
    public static final String GetStudentList = "Student_Details";

    // public static final String SERVICENAMESPACE = "http://10.133.20.159/";
    // public static final String SERVICEURL = "http://localhost:58639/WebServiceAPI.asmx";
//    192.168.43.191

    public static final String loginStatus = "1-Login not Successful";
    static Object rest;
    private SoapObject request;


//    public static GetUserallDetails(String dcode, String mobnum, String otp) {
//
//        return
//    }


    public static String AuthenticatMethod(String diceCode,String mobno,String otp)
    {

        SoapObject request = new SoapObject(SERVICENAMESPACE, AuthenticateMethod);

        request.addProperty("DiseCode", diceCode);
        request.addProperty("MobileNumber", mobno);
        request.addProperty("otp", otp);

        try {
            SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
                    SoapEnvelope.VER11);
            envelope.dotNet = true;
            envelope.implicitTypes = true;
            envelope.setOutputSoapObject(request);

            HttpTransportSE androidHttpTransport = new HttpTransportSE(
                    SERVICEURL);
            androidHttpTransport.call(SERVICENAMESPACE + AuthenticateMethod,envelope);
            // res2 = (SoapObject) envelope.getResponse();
            rest = envelope.getResponse().toString();

        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }

        return rest.toString();
    }


    public static ArrayList<StudentInfo> GetStudentList(String disecode) {

        SoapObject request = new SoapObject(SERVICENAMESPACE, GetStudentList);

        request.addProperty("disecode", disecode);

        SoapObject res1;
        try {

            SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
            envelope.dotNet = true;
            envelope.setOutputSoapObject(request);
            envelope.addMapping(SERVICENAMESPACE, StudentInfo.getdata.getSimpleName(), StudentInfo.getdata);

            HttpTransportSE androidHttpTransport = new HttpTransportSE(SERVICEURL);
            androidHttpTransport.call(SERVICENAMESPACE + GetStudentList, envelope);

            res1 = (SoapObject) envelope.getResponse();

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        int TotalProperty = res1.getPropertyCount();
        ArrayList<StudentInfo> pvmArrayList = new ArrayList<StudentInfo>();
        if(TotalProperty>0) {


            for (int ii = 0; ii < TotalProperty; ii++) {
                if (res1.getProperty(ii) != null) {
                    Object property = res1.getProperty(ii);
                    if (property instanceof SoapObject) {
                        SoapObject final_object = (SoapObject) property;
                        StudentInfo state = new StudentInfo(final_object);
                        pvmArrayList.add(state);
                    }
                } else
                    return pvmArrayList;
            }
        }
        return pvmArrayList;
    }
}

