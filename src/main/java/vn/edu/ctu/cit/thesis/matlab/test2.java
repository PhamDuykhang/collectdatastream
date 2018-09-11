package vn.edu.ctu.cit.thesis.matlab;

import com.mathworks.toolbox.javabuilder.MWException;
import ij.io.FileInfo;
import ij.plugin.DICOM;
import org.apache.commons.lang3.StringUtils;
import org.dcm4che2.data.DicomElement;
import org.dcm4che2.data.DicomObject;
import org.dcm4che2.data.Tag;
import org.dcm4che2.io.DicomInputStream;
import org.dcm4che2.media.DicomDirReader;

import java.io.File;
import java.io.IOException;


public class test2 {
    public static void main(String[] args) throws MWException {
//      HemorrhageFeatureData kq=DicomExtract.getInstance().creatFeature("C:/Users/Asus/Desktop/Newfolder/7-I320_2");
//        System.out.println(kq.toString());
//        System.out.println(String.format("%.4f",kq.getSolidity()));
        DICOM dicom= new DICOM();
//        dicom.open("C:/Users/Asus/Desktop/Newfolder/7-I320_2");
//        FileInfo fi=dicom.getFileInfo();
//        System.out.println(fi.info);
//        String kq=dicom.getInfo("C:/Users/Asus/Desktop/Newfolder/7-I320_2");
        try {
            DicomInputStream dicomInputStream = new DicomInputStream(new File("C:/Users/Asus/Desktop/Newfolder/7-I320_2"));
            DicomObject info= dicomInputStream.getDicomObject();
            System.out.println(info.toString());


        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
