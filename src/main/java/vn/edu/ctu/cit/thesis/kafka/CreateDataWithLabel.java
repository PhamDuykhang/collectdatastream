package vn.edu.ctu.cit.thesis.kafka;

import com.mathworks.toolbox.javabuilder.MWException;
import vn.edu.ctu.cit.thesis.kafka.kafkautils.DirUtils;
import vn.edu.ctu.cit.thesis.matlab.DicomExtract;
import vn.edu.ctu.cit.thesis.matlab.HemorrhageFeatureData;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class CreateDataWithLabel {
    private static final String  DICOM_DIRECTORY ="data/Datae/4-khong benh";
    private static final String  DICOM_DIRECTORY_OUT_PUT_FILE ="data/data-co khong benh/newdicomdata-4.json";
    private static final int LABEL=4;
    public static void main(String[] args) {
        try{
            FileWriter fileWriter  = new FileWriter(DICOM_DIRECTORY_OUT_PUT_FILE);
            BufferedWriter out = new BufferedWriter(fileWriter);
            ArrayList<String> listfile = DirUtils.getListFileName(DICOM_DIRECTORY);

            for(String file:listfile){
                HemorrhageFeatureData data= DicomExtract.getInstance().creatFeature(file,10000);
                data.setLabel(LABEL);
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
