package vn.edu.ctu.cit.thesis.kafka;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.mathworks.toolbox.javabuilder.MWException;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.log4j.Logger;
import vn.edu.ctu.cit.thesis.kafka.kafkautils.CallBackProducer;
import vn.edu.ctu.cit.thesis.kafka.kafkautils.DirUtils;
import vn.edu.ctu.cit.thesis.matlab.DicomExtract;
import vn.edu.ctu.cit.thesis.matlab.HemorrhageFeatureData;
import vn.edu.ctu.cit.thesis.matlab.HemorrhageFeatureDataWithLable;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

public class GeneraDataFromJsonDir implements Runnable {
//    private static final String  DICOM_DIRECTORY_OUT_PUT_FILE ="data/dicomwithoutlabel.json";
    private static final Logger logger = Logger.getLogger(GeneraDataFromJsonDir.class);
    private String topic;
    private String dirpath;
    private Gson gson;
    private Producer<String,String> producer;
    BufferedReader bufferedReader = null;
    @Override
    public void run(){
        logger.info("Processing path "+dirpath);
        try {
            logger.debug("topic="+ this.topic);
            logger.debug("dirpat= "+dirpath);
            if(Objects.isNull(this.producer)){
                logger.debug("Producer is null");
            }
            creatStreamDicom(this.topic, this.dirpath, this.producer);
        }
        catch (IOException ioe){
            logger.error(ioe.getMessage());
        }
    }
    private void creatStreamDicom(String topic, String dirpath, Producer<String,String> producer) throws IOException{

            bufferedReader = new BufferedReader(new FileReader(dirpath));
            bufferedReader.lines().forEach(line->{
                HemorrhageFeatureDataWithLable data = gson.fromJson(line ,HemorrhageFeatureDataWithLable.class);
                producer.send(new ProducerRecord<String,String>(topic,data.getFileName(),line),new CallBackProducer(topic,data.getFileName(),line));
                });
    }

}
