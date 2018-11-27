package vn.edu.ctu.cit.thesis.matlab;

public class ResultUtils {
    private String filename;
    private String PatientInfo;
    private String FeatureVector;
    public  ResultUtils NomalizeResult(String fileName,Object[] resultObject){
        this.filename= fileName;
        this.FeatureVector = resultObject[1].toString().trim().replaceAll("\\s+"," ").replaceAll("\\r\\n"," ");
        this.PatientInfo = resultObject[0].toString();
        return this;
    }
    public ResultUtils WaveletNomalizeResult(String filename,Object[] resultObject){
        this.filename =filename;
        this.FeatureVector = resultObject[0].toString();
        return this;
    }
    public WaveletData toWaveletData(){
        WaveletData cache = new WaveletData();
        String[] cacheStringFeature= FeatureVector.trim().trim().replaceAll("\\s+"," ").replaceAll("\\r\\n"," ").split(" ");
        cache.setFilename(this.filename);
        cache.setContrastV2(Float.valueOf(cacheStringFeature[4]));
        cache.setCorrelationV2(Float.valueOf(cacheStringFeature[5]));
        cache.setEnergyV2(Float.valueOf(cacheStringFeature[6]));
        cache.setHomogeneityV2(Float.valueOf(cacheStringFeature[7]));
        cache.setEntropyV2(Float.valueOf(cacheStringFeature[8]));
       //---------------
        cache.setContrastH2(Float.valueOf(cacheStringFeature[9]));
        cache.setCorrelationH2(Float.valueOf(cacheStringFeature[10]));
        cache.setEnergyH2(Float.valueOf(cacheStringFeature[15]));
        cache.setHomogeneityH2(Float.valueOf(cacheStringFeature[16]));
        cache.setEntropyH2(Float.valueOf(cacheStringFeature[17]));
        return cache;
    }
    public HemorrhageFeatureData toHemorrhageFeature(int numberreduce){
        float index = numberreduce;
        HemorrhageFeatureData cache = new HemorrhageFeatureData();
        String[] cacheStringFeature = FeatureVector.split(" ");
        String[] cacheStringPatientInfo = PatientInfo.split(":");
        //Info Add
        cache.setFileName(this.filename);
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
        cache.setArea(Float.valueOf(cacheStringFeature[4])/index);
        cache.setCentroidX(Float.valueOf(cacheStringFeature[5])/index);
        cache.setCentroidY(Float.valueOf(cacheStringFeature[6])/index);
        cache.setPerimeter(Float.valueOf(cacheStringFeature[7])/index);
        cache.setDistanceWithSkull(Float.valueOf(cacheStringFeature[8])/index);
        cache.setDiameter(Float.valueOf(cacheStringFeature[9])/index);
        cache.setSolidity(Float.valueOf(cacheStringFeature[14])/index);
        cache.setConvexArea(Float.valueOf(cacheStringFeature[15])/index);
        cache.setBBULX(Float.valueOf(cacheStringFeature[16])/index);
        cache.setBBULY(Float.valueOf(cacheStringFeature[17])/index);
        cache.setBBWith(Float.valueOf(cacheStringFeature[18])/index);
        cache.setBBHeight(Float.valueOf(cacheStringFeature[19])/index);
        cache.setFilledArea(Float.valueOf(cacheStringFeature[24])/index);
        cache.setExtent(Float.valueOf(cacheStringFeature[25])/index);
        cache.setEccentricity(Float.valueOf(cacheStringFeature[26])/index);
        cache.setMajorAxisLength(Float.valueOf(cacheStringFeature[27])/index);
        cache.setMinorAxisLength(Float.valueOf(cacheStringFeature[28])/index);
        cache.setOrientation(Float.valueOf(cacheStringFeature[29])/index);
        return cache;
    }
}
