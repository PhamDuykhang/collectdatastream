package vn.edu.ctu.cit.thesis.matlab;


import com.mathworks.toolbox.javabuilder.MWException;
import detectbrainhemorrhage.BrainHemorrhageExtraction;

public class test111 {
    public static void main(String[] args) {
        BrainHemorrhageExtraction extraction;
        try {
            extraction = new BrainHemorrhageExtraction();
            Object[] restl = extraction.ExtractFeature(2,"C:/Users/Asus/Desktop/Newfolder/du lieu da phan loai/Wavelet sample/FFF/null/10-I220 (2)-co benh");
           ResultUtils utils = new ResultUtils();
           HemorrhageFeatureData data = utils.NomalizeResult("I280",restl).toHemorrhageFeature(10);
            System.out.println(data.toJson());
        } catch (MWException e) {
            e.printStackTrace();
        }
    }
}
