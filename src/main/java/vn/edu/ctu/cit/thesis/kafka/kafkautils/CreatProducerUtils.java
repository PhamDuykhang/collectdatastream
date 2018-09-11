package vn.edu.ctu.cit.thesis.kafka.kafkautils;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.log4j.Logger;

import java.util.Properties;

public class CreatProducerUtils{
    private static final Logger logger = Logger.getLogger(CreatProducerUtils.class);
    private static Properties poducerproperties;
    KafkaProducer kafkaProducer;
    public CreatProducerUtils(){

    }

    public static Properties getPoducerproperties() {
        return poducerproperties;
    }

    public  CreatProducerUtils setPoducerproperties(Properties poducerproperties) {
        CreatProducerUtils.poducerproperties = poducerproperties;
        return this;
    }

    public KafkaProducer getKafkaProducer() {
        Properties kafkaproperties = new Properties();
        kafkaproperties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,poducerproperties.getProperty("kafka.bootstrap.servers"));
        kafkaproperties.put(ProducerConfig.ACKS_CONFIG,poducerproperties.getProperty("kafka.acks"));
        kafkaproperties.put(ProducerConfig.RETRIES_CONFIG,poducerproperties.getProperty("kafka.retries"));
        kafkaproperties.put(ProducerConfig.BATCH_SIZE_CONFIG, poducerproperties.getProperty("kafka.batch.size"));
        kafkaproperties.put(ProducerConfig.LINGER_MS_CONFIG, poducerproperties.getProperty("kafka.linger.ms"));
        kafkaproperties.put(ProducerConfig.MAX_REQUEST_SIZE_CONFIG, poducerproperties.getProperty("kafka.max.request.size"));
        kafkaproperties.put(ProducerConfig.COMPRESSION_TYPE_CONFIG, poducerproperties.getProperty("kafka.compression.type"));
        kafkaproperties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer");
        kafkaproperties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer");
        logger.info("Read kafka properties successfully!");
        logger.info("Bootstrap server: "+kafkaproperties.getProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG));
        KafkaProducer<String,String> kafkaproducer = new KafkaProducer<String,String>(kafkaproperties);
        logger.info("Create kafka producer successfully");
        return kafkaproducer;
    }

    private void setKafkaProducer(KafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }
}
