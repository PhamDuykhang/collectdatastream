package vn.edu.ctu.cit.thesis.kafka;

import com.mathworks.toolbox.javabuilder.MWException;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.log4j.Logger;
import vn.edu.ctu.cit.thesis.kafka.kafkautils.CallBackProducer;
import vn.edu.ctu.cit.thesis.kafka.kafkautils.DirUtils;
import vn.edu.ctu.cit.thesis.matlab.DicomExtract;
import vn.edu.ctu.cit.thesis.matlab.HemorrhageFeatureData;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

public class GeneraDataFormDicomDir implements Runnable {
    private static String  DICOM_DIRECTORY_OUT_PUT_FILE ="E:/Code IDEA/collectdatastream/dicomdata222.csv";
    private static final Logger logger = Logger.getLogger(GeneraDataFormDicomDir.class);
    private String topic;
    private String dirpath;
    private Producer<String,String> producer;

    public GeneraDataFormDicomDir(String topic, String dirpath, Producer<String, String> producer) {
//        this.extraction = extraction;
        this.topic = topic;
        this.dirpath = dirpath;
        this.producer = producer;
    }

    @Override
    public void run() {
        logger.info("Processing path "+dirpath);
        try {
            logger.debug("topic="+ this.topic);
            logger.debug("dirpat= "+dirpath);
            if(Objects.isNull(this.producer)){
                logger.debug("Producer is null");
            }
            creatStreamDicom(this.topic, this.dirpath, this.producer);
        }
        catch (MWException e){
            logger.error(e.getMessage());
        }
        catch (IOException ioe){
            logger.error(ioe.getMessage());
        }
    }
    private void creatStreamDicom(String topic, String dirpath, Producer<String,String> producer) throws IOException,MWException {
//        FileWriter fileWriter  = new FileWriter(DICOM_DIRECTORY_OUT_PUT_FILE);
        ArrayList<String> filepaths = DirUtils.getListFileName(dirpath);
        String label = DirUtils.getLabelFromFolderName(dirpath);
        for(String fullpath:filepaths){
            HemorrhageFeatureData result=DicomExtract.getInstance().creatFeature(fullpath,10000);
            result.setLabel(Integer.valueOf(label));
            producer.send(new ProducerRecord<String, String>(topic,DirUtils.getFileNameFormPatch(fullpath),result.toJson()),new CallBackProducer(topic,fullpath,result.toJson()));
        }
    }
}
