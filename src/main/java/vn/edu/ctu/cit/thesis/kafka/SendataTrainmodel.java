package vn.edu.ctu.cit.thesis.kafka;

import com.mathworks.toolbox.javabuilder.MWException;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.log4j.Logger;
import vn.edu.ctu.cit.thesis.kafka.kafkautils.CreatProducerUtils;
import vn.edu.ctu.cit.thesis.kafka.kafkautils.DirUtils;
import vn.edu.ctu.cit.thesis.kafka.kafkautils.PropertyFileReader;
import vn.edu.ctu.cit.thesis.matlab.DicomExtract;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

public class SendataTrainmodel {
    private static final Logger logger = Logger.getLogger(SendataTrainmodel.class);
    private static final String TOPIC_NAME="TRAIN";
    private static final String  DICOM_DIRECTORY ="E:/Datae";
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
            ArrayList<String> listfolder = DirUtils.getListFolder(DICOM_DIRECTORY);
            for (String folder:listfolder){
                Thread thread = new Thread(new GeneraDataFormDicomDir(TOPIC_NAME,folder,kafkaproducer));
                thread.start();
            }
        }catch (IOException e){
            logger.error(e.getMessage());
        } catch (MWException e) {
            e.printStackTrace();
        }
    }
}
