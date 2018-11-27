package vn.edu.ctu.cit.thesis.matlab;

import com.mathworks.toolbox.javabuilder.MWException;
import detectbrainhemorrhage.BrainHemorrhageExtraction;

public class test3 {
    public static void main(String[] args) {
//        BrainHemorrhageExtraction extraction;
//         Object[] result;

        try {
//            extraction = new BrainHemorrhageExtraction();
//            result = extraction.ExtractFeature(2,"C:/Users/Asus/Desktop/Newfolder/DICOMFILE/New/testdata/1-I310_Epidural Hematoma");
//            System.out.println(result[0]);
//            String[] Patientfeat = result[1].toString().trim().replaceAll("\\s+"," ").replaceAll("\\r\\n"," ").split(" ");
//            String[] ParIf  = result[0].toString().split(":");
//            for(String el : Patientfeat){
//                System.out.println(el);
//            }



            HemorrhageFeatureData data = DicomExtract.getInstance().creatFeature("C:/Users/Asus/Desktop/Newfolder/DICOMFILE/New/testdata/1-I310_Epidural Hematoma",10000);
            System.out.println(data.toString());
        } catch (MWException e) {
            e.printStackTrace();
        }
    }
}
