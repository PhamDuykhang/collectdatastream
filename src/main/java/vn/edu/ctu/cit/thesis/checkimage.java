package vn.edu.ctu.cit.thesis;

import com.mathworks.toolbox.javabuilder.MWException;
import vn.edu.ctu.cit.thesis.kafka.kafkautils.DirUtils;
import vn.edu.ctu.cit.thesis.matlab.DicomExtract;
import vn.edu.ctu.cit.thesis.matlab.HemorrhageFeatureData;

import java.io.IOException;
import java.util.ArrayList;

public class checkimage {
    private static String  DICOM_DIRECTORY ="C:/Users/Asus/Desktop/Newfolder/DICOMFILE/New/testdata/3-noi so";
    public static void main(String[] args) {
        try {
            ArrayList<String> listfile = DirUtils.getListFileName(DICOM_DIRECTORY);
            for(String filename:listfile){
                HemorrhageFeatureData data=DicomExtract.getInstance().creatFeature(filename,1000);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (MWException e) {
            e.printStackTrace();
        }
    }
}
