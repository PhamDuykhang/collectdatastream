package vn.edu.ctu.cit.thesis.matlab;

import com.mathworks.toolbox.javabuilder.MWException;
import ij.io.FileInfo;
import ij.io.FileSaver;
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

        dicom.open("C:/Users/Asus/Desktop/Newfolder/du lieu da phan loai/New folder/17-I120");
//        FileInfo fileInfo=dicom.getFileInfo();
        dicom.show();
        dicom.saveRoi();
        FileSaver fileSaver = new FileSaver(dicom);
        fileSaver.saveAsJpeg("data/h.jpg");
//


    }
}
