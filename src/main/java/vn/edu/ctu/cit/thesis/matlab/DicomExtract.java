package vn.edu.ctu.cit.thesis.matlab;


import com.mathworks.toolbox.javabuilder.MWException;
import detectbrainhemorrhage.BrainHemorrhageExtraction;
import vn.edu.ctu.cit.thesis.kafka.kafkautils.DirUtils;


import java.util.Objects;

public class DicomExtract {
    private BrainHemorrhageExtraction extraction;
    private Object[] result;
    private static  DicomExtract instance;
    private DicomExtract() throws MWException {
        extraction = new BrainHemorrhageExtraction();
        result = null;
    }
    public static synchronized DicomExtract getInstance () throws MWException {
        if(Objects.isNull(instance)){
            instance = new DicomExtract();
        }
        return instance;
    }
    public HemorrhageFeatureData creatFeature(String dicomfilepath,int numberreduce) throws MWException {
        result = extraction.ExtractFeature(2,dicomfilepath);
        ResultUtils resultUtils= new ResultUtils();
        return resultUtils.NomalizeResult(DirUtils.getFileNameFormPatch(dicomfilepath),result)
                .toHemorrhageFeature(numberreduce);
    }
}
