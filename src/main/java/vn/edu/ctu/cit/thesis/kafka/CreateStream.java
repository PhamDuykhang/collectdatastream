package vn.edu.ctu.cit.thesis.kafka;


import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.log4j.Logger;

import vn.edu.ctu.cit.thesis.kafka.kafkautils.CreatProducerUtils;
import vn.edu.ctu.cit.thesis.kafka.kafkautils.DirUtils;
import vn.edu.ctu.cit.thesis.kafka.kafkautils.PropertyFileReader;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

public class CreateStream  {
    private static final Logger logger = Logger.getLogger(CreateStream.class);
    private static final String TOPIC_NAME="XXXXX";
    private static String  DICOM_DIRECTORY ="C:/Users/Asus/Desktop/Newfolder/DICOMFILE";
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
            ArrayList<String> dirdicom = DirUtils.getListFolder(DICOM_DIRECTORY);

            for(String dir:dirdicom){
                Thread thread= new Thread(new GeneraDataFormDicomDir(TOPIC_NAME,dir,kafkaproducer));
                thread.start();
            }
        }catch (IOException e){
            logger.error(e.getMessage());
        }



    }
}
