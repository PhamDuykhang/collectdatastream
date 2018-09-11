package vn.edu.ctu.cit.thesis.kafka.kafkautils;

import org.apache.kafka.clients.producer.Producer;

import java.util.Objects;

public class GeneraData {
    public static void GeneraDataWithTopics(Producer producer,String[] topics){
        if (Objects.isNull(topics)){
            throw  new IllegalArgumentException("No information for topics");
        }
        for (String topic :
                topics) {

        }
    }
}
