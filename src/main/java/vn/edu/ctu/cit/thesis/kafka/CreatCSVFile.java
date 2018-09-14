package vn.edu.ctu.cit.thesis.kafka;

import com.mathworks.toolbox.javabuilder.MWException;
import vn.edu.ctu.cit.thesis.kafka.kafkautils.DirUtils;

import vn.edu.ctu.cit.thesis.matlab.DicomExtract;
import vn.edu.ctu.cit.thesis.matlab.HemorrhageFeatureData;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class CreatCSVFile {
    private static String  DICOM_DIRECTORY ="C:/Users/Asus/Desktop/Newfolder/DICOMFILE";
    private static String  DICOM_DIRECTORY_OUT_PUT_FILE ="E:/Code IDEA/collectdatastream/dicomdata.csv";
    public static void main(String[] args) {
        try {
            FileWriter fileWriter  = new FileWriter(DICOM_DIRECTORY_OUT_PUT_FILE);
            BufferedWriter out = new BufferedWriter(fileWriter);
            ArrayList<String> listfile = DirUtils.getListFileName(DICOM_DIRECTORY);
            for (String file:
                 listfile) {
                HemorrhageFeatureData data=DicomExtract.getInstance().creatFeature(file);
                System.out.println(data.toString());
               out.write(data.toString());
              out.newLine();;
              out.flush();
            }
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (MWException e) {
            e.printStackTrace();
        }

    }
}
