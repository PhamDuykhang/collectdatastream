package vn.edu.ctu.cit.thesis.kafka;


import com.mathworks.toolbox.javabuilder.MWException;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.log4j.Logger;

import vn.edu.ctu.cit.thesis.kafka.kafkautils.CreatProducerUtils;
import vn.edu.ctu.cit.thesis.kafka.kafkautils.DirUtils;
import vn.edu.ctu.cit.thesis.kafka.kafkautils.GeneraData;
import vn.edu.ctu.cit.thesis.kafka.kafkautils.PropertyFileReader;
import vn.edu.ctu.cit.thesis.matlab.DicomExtract;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

public class CreateStream  {
    private static final Logger logger = Logger.getLogger(CreateStream.class);
    private static final String TOPIC_NAME="XXXXX";
    private static final String  DICOM_DIRECTORY ="E:/Rundemo/CHO RAY";
    public static void main(String[] args) {
        Properties properties;
        try {
            properties = new PropertyFileReader()
                    .setPropertyName(PropertyFileReader.DEFAULT_PATCH)
                    .readProperty();
            logger.info("Read properties successfully!");
            KafkaProducer kafkaproducer = new CreatProducerUtils()
                    .setPoducerproperties(properties)
                    .getKafkaProducer();
            DicomExtract.getInstance();
            System.out.println("Bat dau nhan du lieu");
            while(true) {
                ArrayList<String> listfile = DirUtils.getListFileName(DICOM_DIRECTORY);
                if(!listfile.isEmpty()){
                    System.out.println("Processing");
                    for(String filepath :listfile){
                        Gendata generaData = new Gendata (TOPIC_NAME,filepath,kafkaproducer);
                        generaData.crate();
                        DirUtils.moveFile(filepath,"E:/Rundemo/Backup/"+DirUtils.getFileNameFormPatch(filepath));
                    }

                }
			}
        }catch (IOException e){
            logger.error(e.getMessage());
        } catch (MWException e) {
            e.printStackTrace();
        }


    }
}
