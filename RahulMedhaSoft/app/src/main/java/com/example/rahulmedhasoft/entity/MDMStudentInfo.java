package com.example.rahulmedhasoft.entity;

import org.ksoap2.serialization.KvmSerializable;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;

import java.util.ArrayList;
import java.util.Hashtable;

public class MDMStudentInfo extends ArrayList<StudentInfo> implements KvmSerializable {

    public static Class<StudentInfo> getdata = StudentInfo.class;

    private String ResultStatusMesg = "";
    private String a_Id = "";
    private String BeneficieryId = "";
    private String DiseCode = "";
    private String ClassId = "";
    private String BeneficieryName = "";
    private String FHName = "";
    private String MName = "";
    private String Gender = "";
    private String DOB = "";
    private String BenAccountNo = "";
    private String IFSCCode = "";
    private String eupi_BenNameasPerBank = "";
    private String maxscore = "";
    private String MDMPER = "";
    private String MDMPERBY = "";
    private String MDMPERDATE = "";

    public String getMDMPER() {
        return MDMPER;
    }

    public void setMDMPER(String MDMPER) {
        this.MDMPER = MDMPER;
    }

    public String getMDMPERBY() {
        return MDMPERBY;
    }

    public void setMDMPERBY(String MDMPERBY) {
        this.MDMPERBY = MDMPERBY;
    }

    public String getMDMPERDATE() {
        return MDMPERDATE;
    }

    public void setMDMPERDATE(String MDMPERDATE) {
        this.MDMPERDATE = MDMPERDATE;
    }

    public MDMStudentInfo() {}

    public MDMStudentInfo(SoapObject obj) {
        this.setResultStatusMesg(obj.getProperty("ResultStatusMesg").toString());
        this.setA_Id(obj.getProperty("a_Id").toString());
        this.setBeneficieryId(obj.getProperty("BeneficieryId").toString());
        this.setDiseCode(obj.getProperty("DiseCode").toString());
        this.setClassId(obj.getProperty("ClassId").toString());
        this.setBeneficieryName(obj.getProperty("BeneficieryName").toString());
        this.setFHName(obj.getProperty("FHName").toString());
        this.setMName(obj.getProperty("MName").toString());
        this.setGender(obj.getProperty("Gender").toString());
        this.setDOB(obj.getProperty("DOB").toString());
        this.setBenAccountNo(obj.getProperty("BenAccountNo").toString());
        this.setIFSCCode(obj.getProperty("IFSCCode").toString());
        this.setEupi_BenNameasPerBank(obj.getProperty("eupi_BenNameasPerBank").toString());
        this.setMaxscore(obj.getProperty("maxscore").toString());
        this.setMDMPER(obj.getProperty("MDMPER").toString());
        this.setMDMPERBY(obj.getProperty("MDMPERBY").toString());
        this.setMDMPERDATE(obj.getProperty("MDMPERDATE").toString());
    }

    public String getResultStatusMesg() {
        return ResultStatusMesg;
    }

    public void setResultStatusMesg(String resultStatusMesg) {
        ResultStatusMesg = resultStatusMesg;
    }

    public String getA_Id() {
        return a_Id;
    }

    public void setA_Id(String a_Id) {
        this.a_Id = a_Id;
    }

    public String getBeneficieryId() {
        return BeneficieryId;
    }

    public void setBeneficieryId(String beneficieryId) {
        BeneficieryId = beneficieryId;
    }

    public String getDiseCode() {
        return DiseCode;
    }

    public void setDiseCode(String diseCode) {
        DiseCode = diseCode;
    }

    public String getClassId() {
        return ClassId;
    }

    public void setClassId(String classId) {
        ClassId = classId;
    }

    public String getBeneficieryName() {
        return BeneficieryName;
    }

    public void setBeneficieryName(String beneficieryName) {
        BeneficieryName = beneficieryName;
    }

    public String getFHName() {
        return FHName;
    }

    public void setFHName(String FHName) {
        this.FHName = FHName;
    }

    public String getMName() {
        return MName;
    }

    public void setMName(String MName) {
        this.MName = MName;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    public String getDOB() {
        return DOB;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }

    public String getBenAccountNo() {
        return BenAccountNo;
    }

    public void setBenAccountNo(String benAccountNo) {
        BenAccountNo = benAccountNo;
    }

    public String getIFSCCode() {
        return IFSCCode;
    }

    public void setIFSCCode(String IFSCCode) {
        this.IFSCCode = IFSCCode;
    }

    public String getEupi_BenNameasPerBank() {
        return eupi_BenNameasPerBank;
    }

    public void setEupi_BenNameasPerBank(String eupi_BenNameasPerBank) {
        this.eupi_BenNameasPerBank = eupi_BenNameasPerBank;
    }

    public String getMaxscore() {
        return maxscore;
    }

    public void setMaxscore(String maxscore) {
        this.maxscore = maxscore;
    }

    @Override
    public Object getProperty(int i) {
        return null;
    }

    @Override
    public int getPropertyCount() {
        return 0;
    }

    @Override
    public void setProperty(int i, Object o) {

    }

    @Override
    public void getPropertyInfo(int i, Hashtable hashtable, PropertyInfo propertyInfo) {

    }

}