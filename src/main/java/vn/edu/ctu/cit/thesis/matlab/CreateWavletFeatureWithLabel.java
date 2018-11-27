package vn.edu.ctu.cit.thesis.matlab;

import com.mathworks.toolbox.javabuilder.MWException;
import vn.edu.ctu.cit.thesis.kafka.kafkautils.DirUtils;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class CreateWavletFeatureWithLabel {
    private static final String  DICOM_DIRECTORY =
            "C:/Users/Asus/Desktop/Newfolder/du lieu da phan loai/Wavelet sample/jpg/3-noi so";
    private static final String DICOM_DIRECTORY_OUT_PUT_FILE ="data/jpg/waveletdicomdata-3.json";
    private static final int LABEL=3;

    public static void main(String[] args) {
        try{
            FileWriter fileWriter  = new FileWriter(DICOM_DIRECTORY_OUT_PUT_FILE);
            BufferedWriter out = new BufferedWriter(fileWriter);
            ArrayList<String> listfile = DirUtils.getListFileName(DICOM_DIRECTORY);
            for(String file:listfile){
                WaveletData data= WaveletExtraction.getInstance().extract(file);
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
