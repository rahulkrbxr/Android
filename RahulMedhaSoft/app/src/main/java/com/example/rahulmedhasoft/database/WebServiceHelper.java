package com.example.rahulmedhasoft.database;

import android.content.Context;
import android.util.Log;

import com.example.rahulmedhasoft.entity.UserDetails;


import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;



public class WebServiceHelper {


     public static final String SERVICENAMESPACE = "http://schoolwebservice:8080/";
    public static final String SERVICEURL = "http://localhost:58639/WebServiceAPI.asmx";
    public static final String AuthenticateMethod = "SchoolLogin";

    // public static final String SERVICENAMESPACE = "http://10.133.20.159/";
    // public static final String SERVICEURL = "http://localhost:58639/WebServiceAPI.asmx";

    public static final String loginStatus = "1-Login not Successful";
    static String rest;


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
}

