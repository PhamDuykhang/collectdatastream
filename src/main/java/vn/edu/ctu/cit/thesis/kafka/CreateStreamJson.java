package vn.edu.ctu.cit.thesis.kafka;

import com.google.gson.Gson;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.log4j.Logger;
import vn.edu.ctu.cit.thesis.kafka.kafkautils.CallBackProducer;
import vn.edu.ctu.cit.thesis.kafka.kafkautils.CreatProducerUtils;
import vn.edu.ctu.cit.thesis.kafka.kafkautils.DirUtils;
import vn.edu.ctu.cit.thesis.kafka.kafkautils.PropertyFileReader;
import vn.edu.ctu.cit.thesis.matlab.HemorrhageFeatureDataWithLable;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

public class CreateStreamJson {
    private static final Logger logger = Logger.getLogger(CreateStreamJson.class);
    private static final String TOPIC_NAME="XXXXX";
    private static final String  DICOM_DIRECTORY ="data/dicomwithoutlabel.json";
    public static void main(String[] args) {
        Properties properties;
        Gson gson = new Gson();
        try {
            properties = new PropertyFileReader()
                    .setPropertyName(PropertyFileReader.DEFAULT_PATCH)
                    .readProperty();
            logger.info("Read properties successfully!");
            KafkaProducer kafkaproducer = new CreatProducerUtils()
                    .setPoducerproperties(properties)
                    .getKafkaProducer();
            BufferedReader bufferedReader = new BufferedReader(new FileReader(DICOM_DIRECTORY));
            bufferedReader.lines().forEach(line->{
                HemorrhageFeatureDataWithLable data = gson.fromJson(line ,HemorrhageFeatureDataWithLable.class);
                kafkaproducer.send(new ProducerRecord<String,String>(TOPIC_NAME,data.getFileName(),line),new CallBackProducer(TOPIC_NAME,data.getFileName(),line));
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }catch (IOException e){
            logger.error(e.getMessage());
        }



    }
}
