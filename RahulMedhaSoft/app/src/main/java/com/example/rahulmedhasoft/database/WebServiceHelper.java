package com.example.rahulmedhasoft.database;

import com.example.rahulmedhasoft.entity.GetStudentDetails;


import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

public class WebServiceHelper {


//  public static final String SERVICENAMESPACE = "http://schoolwebservice:8080/";
    public static final String SERVICENAMESPACE = "http://10.133.20.135:4545/";
    public static final String SERVICEURL = "http://10.133.20.135:4545/WebServiceAPI.asmx";
//    public static final String SERVICEURL = "http://10.133.20.135:8081/WebServiceAPI.asmx";
    public static final String AuthenticateMethod = "Authenticate";
    public static final String AuthenticateMethodStudents = "Student_Details";

    // public static final String SERVICENAMESPACE = "http://10.133.20.159/";
    // public static final String SERVICEURL = "http://localhost:58639/WebServiceAPI.asmx";

    public static final String loginStatus = "1-Login not Successful";
    static Object rest;


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

    public Object GetStudentWebService(String diceCode)
    {

        SoapObject request = new SoapObject(SERVICENAMESPACE, AuthenticateMethodStudents);

        request.addProperty("DiseCode", diceCode);

        try {
            SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
                    SoapEnvelope.VER11);
            envelope.dotNet = true;
            envelope.implicitTypes = true;
            envelope.setOutputSoapObject(request);

            HttpTransportSE androidHttpTransport = new HttpTransportSE(
                    SERVICEURL);
            androidHttpTransport.call(SERVICENAMESPACE + AuthenticateMethodStudents,envelope);
            // res2 = (SoapObject) envelope.getResponse();
            rest = envelope.getResponse();

        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }

        return rest;
    }
}

