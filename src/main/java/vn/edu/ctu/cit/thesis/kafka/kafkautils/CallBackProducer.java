package vn.edu.ctu.cit.thesis.kafka.kafkautils;

import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.log4j.Logger;

public class CallBackProducer implements Callback {
    private static final Logger logger = Logger.getLogger(CallBackProducer.class);
    private String topic;
    private String path;
    public CallBackProducer(String topic,String path){
        this.topic=topic;
        this.path=path;
    }
    @Override
    public void onCompletion(RecordMetadata recordMetadata, Exception e) {
    if(recordMetadata != null ){
        logger.info("-----------------------------------");
        logger.info("Topic: "+topic+ "Path"+path + recordMetadata.partition());
        logger.info("-----------------------------------");
        logger.info("\n");
    }
    if(e!=null){
        logger.error(e.getMessage());
    }
    }
}
