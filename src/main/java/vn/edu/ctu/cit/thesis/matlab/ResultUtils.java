package vn.edu.ctu.cit.thesis.matlab;

public class ResultUtils {
    private String PatientInfo;
    private String FeatureVector;
    public  ResultUtils NomalizeResult(Object[] resultObject){
        this.FeatureVector = resultObject[1].toString().trim().replaceAll("\\s+"," ").replaceAll("\\r\\n"," ");
        this.PatientInfo = resultObject[0].toString();
        return this;
    }
    public HemorrhageFeatureData toHemorrhageFeature(){
        HemorrhageFeatureData cache = new HemorrhageFeatureData();
        String[] cacheStringFeature = FeatureVector.split(" ");
        String[] cacheStringPatientInfo = PatientInfo.split(":");
        //Info Add
        cache.setPatientID(cacheStringPatientInfo[0]);
        cache.setPatientName(cacheStringPatientInfo[1]);
        cache.setPatientAge(cacheStringPatientInfo[2]);
        cache.setPatientSex(cacheStringPatientInfo[3]);
        cache.setInstitutionName(cacheStringPatientInfo[4]);
        cache.setInstitutionAddress(cacheStringPatientInfo[5]);
        cache.setAccessionNumber(cacheStringPatientInfo[6]);
        cache.setManufacturer(cacheStringPatientInfo[7]);
        cache.setModality(cacheStringPatientInfo[8]);
        //Feature add
        cache.setArea(Float.valueOf(cacheStringFeature[6]));
        cache.setCentroidX(Float.valueOf(cacheStringFeature[7]));
        cache.setCentroidY(Float.valueOf(cacheStringFeature[8]));
        cache.setPerimeter(Float.valueOf(cacheStringFeature[9]));
        cache.setDistanceWithSkull(Float.valueOf(cacheStringFeature[10]));
        cache.setEquivDiameter(Float.valueOf(cacheStringFeature[11]));
        cache.setAreaBoudingbox(Float.valueOf(cacheStringFeature[12]));
        cache.setSolidity(Float.valueOf(cacheStringFeature[17]));
        cache.setExtent(Float.valueOf(cacheStringFeature[18]));
        cache.setEccentricity(Float.valueOf(cacheStringFeature[19]));
        cache.setMajorAxisLength(Float.valueOf(cacheStringFeature[20]));
        cache.setMinorAxisLength(Float.valueOf(cacheStringFeature[21]));
        cache.setOrientation(Float.valueOf(cacheStringFeature[22]));
        return cache;
    }
}
