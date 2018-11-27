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
    private static String  DICOM_DIRECTORY ="C:/Users/Asus/Desktop/Newfolder/DICOMFILE/New/testdata";
    private static String  DICOM_DIRECTORY_OUT_PUT_FILE ="data/dicomdata.csv";
    public static void main(String[] args) {
        try {
            FileWriter fileWriter  = new FileWriter(DICOM_DIRECTORY_OUT_PUT_FILE);
            BufferedWriter out = new BufferedWriter(fileWriter);
            ArrayList<String> listfile = DirUtils.getListFileName(DICOM_DIRECTORY);
            System.out.println("Total "+listfile.size()+ " files to extract");
            for (String file:
                 listfile) {
                HemorrhageFeatureData data=DicomExtract.getInstance().creatFeature(file,1000);
//                System.out.println(DirUtils.getFileNameFormPatch(file));
                out.write(data.toCsv());
                out.newLine();
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
