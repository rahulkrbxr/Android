package com.example.rahulmedhasoft.entity;

import org.ksoap2.serialization.KvmSerializable;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;

import java.util.Hashtable;

public class GetStudentDetails implements KvmSerializable {

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

    public GetStudentDetails() {

    }

    public GetStudentDetails(SoapObject obj) {
        this.setResultStatusMesg(obj.getProperty("_ResultStatusMesg").toString());
        this.setA_Id(obj.getProperty("_A_Id").toString());
        this.setBeneficieryId(obj.getProperty("_BeneficieryId").toString());
        this.setDiseCode(obj.getProperty("_DiseCode").toString());
        this.setClassId(obj.getProperty("_ClassId").toString());
        this.setBeneficieryName(obj.getProperty("_BeneficieryName").toString());
        this.setFHName(obj.getProperty("_FHName").toString());
        this.setMName(obj.getProperty("_MNName").toString());
        this.setGender(obj.getProperty("_Gender").toString());
        this.setDOB(obj.getProperty("_DOB").toString());
        this.setBenAccountNo(obj.getProperty("_BenAccountNo").toString());
        this.setIFSCCode(obj.getProperty("_IFSCCode").toString());
        this.setEupi_BenNameasPerBank(obj.getProperty("_Eupi_BenNameasPerBank").toString());
        this.setMaxscore(obj.getProperty("_Maxscore").toString());
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
}
