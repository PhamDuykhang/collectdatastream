package vn.edu.ctu.cit.thesis.matlab;

import com.google.gson.Gson;

public class HemorrhageFeatureData {
    private String fileName;
    private String PatientID; //id benh nhan
    private String PatientName; // ten benh nhan
    private String PatientAge; // tuoi benh nhan
    private String PatientSex; // gioi tinh
    private String InstitutionName; // ten bv
    private String institutionAddress; // dic chi benh vien
    private String AccessionNumber; // ngoai tk
    private String Manufacturer; // philips
    private String Modality; // ct
    private float Area;
    private float CentroidX;
    private float CentroidY;
    private float Perimeter;
    private float DistanceWithSkull;
    private float Diameter;
    private float Solidity;
    private float ConvexArea;
    private float BBULX;
    private float BBULY;
    private float BBWith;
    private float BBHeight;
    private float FilledArea;
    private float Extent;
    private float Eccentricity;
    private float MajorAxisLength;
    private float MinorAxisLength;
    private float Orientation;
    private int Label;

    public int getLabel() {
        return Label;
    }

    public void setLabel(int label) {
        Label = label;
    }

    public float getConvexArea() {
        return ConvexArea;
    }

    public void setConvexArea(float convexArea) {
        ConvexArea = convexArea;
    }

    public float getBBULX() {
        return BBULX;
    }

    public void setBBULX(float BBULX) {
        this.BBULX = BBULX;
    }

    public float getBBULY() {
        return BBULY;
    }

    public void setBBULY(float BBULY) {
        this.BBULY = BBULY;
    }

    public float getBBWith() {
        return BBWith;
    }

    public void setBBWith(float BBWith) {
        this.BBWith = BBWith;
    }

    public float getBBHeight() {
        return BBHeight;
    }

    public void setBBHeight(float BBHeight) {
        this.BBHeight = BBHeight;
    }

    public float getFilledArea() {
        return FilledArea;
    }

    public void setFilledArea(float filledArea) {
        FilledArea = filledArea;
    }

    public HemorrhageFeatureData() {
    }

    public float getArea() {
        return Area;
    }

    public void setArea(float area) {
        Area = area;
    }

    public float getCentroidX() {
        return CentroidX;
    }

    public void setCentroidX(float centroidX) {
        CentroidX = centroidX;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public float getCentroidY() {
        return CentroidY;
    }

    public void setCentroidY(float centroidY) {
        CentroidY = centroidY;
    }

    public float getPerimeter() {
        return Perimeter;
    }

    public void setPerimeter(float perimeter) {
        Perimeter = perimeter*2;
    }

    public float getDistanceWithSkull() {
        return DistanceWithSkull;
    }

    public void setDistanceWithSkull(float distanceWithSkull) {
        DistanceWithSkull = distanceWithSkull;
    }

    public float getDiameter() {
        return Diameter;
    }

    public void setDiameter(float diameter) {
        Diameter = diameter*2;
    }

    public float getSolidity() {
        return Solidity;
    }

    public void setSolidity(float solidity) {
        Solidity = solidity;
    }

    public float getExtent() {
        return Extent;
    }

    public void setExtent(float extent) {
        Extent = extent;
    }

    public float getEccentricity() {
        return Eccentricity;
    }

    public void setEccentricity(float eccentricity) {
        Eccentricity = eccentricity;
    }

    public float getMajorAxisLength() {
        return MajorAxisLength;
    }

    public void setMajorAxisLength(float majorAxisLength) {
        MajorAxisLength = majorAxisLength;
    }

    public float getMinorAxisLength() {
        return MinorAxisLength;
    }

    public void setMinorAxisLength(float minorAxisLength) {
        MinorAxisLength = minorAxisLength;
    }

    public float getOrientation() {
        return Orientation;
    }

    public void setOrientation(float orientation) {
        Orientation = orientation;
    }

    public String getPatientID() {
        return PatientID;
    }

    public void setPatientID(String patientID) {
        PatientID = patientID;
    }

    public String getPatientName() {
        return PatientName;
    }

    public void setPatientName(String patientName) {
        PatientName = patientName;
    }

    public String getPatientAge() {
        return PatientAge;
    }

    public void setPatientAge(String patientAge) {
        PatientAge = patientAge.replaceAll("Y", "");
    }

    public String getPatientSex() {
        return PatientSex;
    }

    public void setPatientSex(String patientSex) {
        PatientSex = patientSex;
    }

    public String getInstitutionName() {
        return InstitutionName;
    }

    public void setInstitutionName(String institutionName) {
        InstitutionName = institutionName;
    }

    public String getInstitutionAddress() {
        return institutionAddress;
    }

    public void setInstitutionAddress(String institutionAddress) {
        this.institutionAddress = institutionAddress;
    }

    public String getAccessionNumber() {
        return AccessionNumber;
    }

    public void setAccessionNumber(String accessionNumber) {
        AccessionNumber = accessionNumber;
    }

    public String getManufacturer() {
        return Manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        Manufacturer = manufacturer;
    }

    public String getModality() {
        return Modality;
    }

    public void setModality(String modality) {
        Modality = modality;
    }

    @Override
    public String toString() {
        return  "\"" + fileName + "\"," +
                "\"" + PatientID + "\"," +
                "\"" + PatientName + "\"," +
                "\"" + PatientAge + "\"," +
                "\"" + PatientSex + "\"," +
                "\"" + InstitutionName + "\"," +
                "\"" + institutionAddress + "\"," +
                "\"" + AccessionNumber + "\"," +
                "\"" + Manufacturer + "\"," +
                "\"" + Modality + "\"," +
                String.format("%.5f", Area) + "," +
                String.format("%.5f", CentroidX) + "," +
                String.format("%.5f", CentroidY) + "," +
                String.format("%.5f", Perimeter) + "," +
                String.format("%.5f", DistanceWithSkull) + "," +
                String.format("%.5f", Diameter) + "," +
                String.format("%.5f", Solidity) + "," +
                String.format("%.5f", ConvexArea) + "," +
                String.format("%.5f", BBULX) + "," +
                String.format("%.5f", BBULY) + "," +
                String.format("%.5f", BBWith) + "," +
                String.format("%.5f", BBHeight) + "," +
                String.format("%.5f", FilledArea) + "," +
                String.format("%.5f", Extent) + "," +
                String.format("%.5f", Eccentricity) + "," +
                String.format("%.5f", MajorAxisLength) + "," +
                String.format("%.5f", MinorAxisLength) + "," +
                String.format("%.5f", Orientation);
    }
    public String toCsv() {
        return  fileName + "," +
                PatientID + "," +
                 PatientName + "," +
                 PatientAge + "," +
                 PatientSex + "," +
                InstitutionName + "," +
                institutionAddress + "," +
                AccessionNumber + "," +
                Manufacturer + "," +
                 Modality + "," +
                String.format("%.5f", Area) + "," +
                String.format("%.5f", CentroidX) + "," +
                String.format("%.5f", CentroidY) + "," +
                String.format("%.5f", Perimeter) + "," +
                String.format("%.5f", DistanceWithSkull) + "," +
                String.format("%.5f", Diameter) + "," +
                String.format("%.5f", Solidity) + "," +
                String.format("%.5f", ConvexArea) + "," +
                String.format("%.5f", BBULX) + "," +
                String.format("%.5f", BBULY) + "," +
                String.format("%.5f", BBWith) + "," +
                String.format("%.5f", BBHeight) + "," +
                String.format("%.5f", FilledArea) + "," +
                String.format("%.5f", Extent) + "," +
                String.format("%.5f", Eccentricity) + "," +
                String.format("%.5f", MajorAxisLength) + "," +
                String.format("%.5f", MinorAxisLength) + "," +
                String.format("%.5f", Orientation);
    }
    public String toJson() {
        return new Gson().toJson(this);
    }
}
