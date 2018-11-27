package vn.edu.ctu.cit.thesis.kafka;

import com.mathworks.toolbox.javabuilder.MWException;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import vn.edu.ctu.cit.thesis.kafka.kafkautils.CallBackProducer;
import vn.edu.ctu.cit.thesis.kafka.kafkautils.DirUtils;
import vn.edu.ctu.cit.thesis.matlab.DicomExtract;
import vn.edu.ctu.cit.thesis.matlab.HemorrhageFeatureData;

import java.io.IOException;

public class Gendata {
    private String topic;
    private String dicompath;
    private Producer<String,String> producer;

    public Gendata(String topic, String dicompath, Producer<String, String> producer) {
        this.topic = topic;
        this.dicompath = dicompath;
        this.producer = producer;
    }
    public void crate(){
        try {
            creatStreamDicom(this.topic, this.dicompath, this.producer);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (MWException e) {
            e.printStackTrace();
        }
    }
    private void creatStreamDicom(String topic, String dirpath, Producer<String,String> producer) throws IOException,MWException {
            HemorrhageFeatureData result=DicomExtract.getInstance().creatFeature(dirpath,10000);
            producer.send(new ProducerRecord<String, String>(topic,DirUtils.getFileNameFormPatch(dirpath),result.toJson()),new CallBackProducer(topic,dirpath,result.toJson()));
        }

}

