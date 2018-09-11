package vn.edu.ctu.cit.thesis.matlab;

import DetectBrainHemorrhage.BrainHemorrhageDetection;
import com.mathworks.toolbox.javabuilder.MWException;



import java.util.Objects;

public class DicomExtract {
    private BrainHemorrhageDetection extraction;
    private Object[] result;
    private static  DicomExtract instance;
    private DicomExtract() throws MWException {
        extraction = new BrainHemorrhageDetection();
        result = null;
    }
    public static synchronized DicomExtract getInstance () throws MWException {
        if(Objects.isNull(instance)){
            instance = new DicomExtract();
        }
        return instance;
    }
    public HemorrhageFeatureData creatFeature(String dicomfilepath) throws MWException {
        result = extraction.detectBrainHemorrhage(2,dicomfilepath);
        ResultUtils resultUtils= new ResultUtils();
//        System.out.println("Dicomexxtract"+result[0].toString());
        return resultUtils.NomalizeResult(result)
                .toHemorrhageFeature();
    }
}
