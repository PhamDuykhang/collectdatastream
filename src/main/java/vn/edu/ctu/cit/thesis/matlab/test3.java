package vn.edu.ctu.cit.thesis.matlab;

import com.mathworks.toolbox.javabuilder.MWException;

public class test3 {
    public static void main(String[] args) {
        try {
            HemorrhageFeatureData data = DicomExtract.getInstance().creatFeature("C:/Users/Asus/Desktop/Newfolder/7-I320_2");
            System.out.println(data.toString());
        } catch (MWException e) {
            e.printStackTrace();
        }
    }
}
