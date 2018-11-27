package vn.edu.ctu.cit.thesis.kafka;

import com.mathworks.toolbox.javabuilder.MWException;
import vn.edu.ctu.cit.thesis.kafka.kafkautils.DirUtils;
import vn.edu.ctu.cit.thesis.matlab.DicomExtract;
import vn.edu.ctu.cit.thesis.matlab.HemorrhageFeatureData;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class GenrateDataWhitoutLabel {
    private static final String  DICOM_DIRECTORY ="data/Datae";
    private static final String  DICOM_DIRECTORY_OUT_PUT_FILE ="data/dicomwithoutlabel.json";

    public static void main(String[] args) {
        try{
            FileWriter fileWriter  = new FileWriter(DICOM_DIRECTORY_OUT_PUT_FILE);
            BufferedWriter out = new BufferedWriter(fileWriter);
            ArrayList<String> listfile = DirUtils.getListFileName(DICOM_DIRECTORY);

            for(String file:listfile){
                HemorrhageFeatureData data= DicomExtract.getInstance().creatFeature(file,10000);
                out.write(data.toJson());
                out.newLine();
                out.flush();
                System.out.println(data.toJson());
                System.out.println("----------------------");
//                Thread.sleep(200);

            }
            System.out.println("End");

        }
        catch (IOException ioe){
            ioe.printStackTrace();
        } catch (MWException e) {
            e.printStackTrace();
        }
//        catch (InterruptedException e) {
//            e.printStackTrace();
//        }
    }
}
