package vn.edu.ctu.cit.thesis.kafka.kafkautils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyFileReader {
    private static Properties prop;
    public static final String DEFAULT_PATCH="kafka-properties.properties";
    private static String propertyName;
    public PropertyFileReader () {
        this.prop = new Properties();
        this.propertyName = "";
    }
    public String getPropertyName() {
        return propertyName;
    }
    public  PropertyFileReader setPropertyName(String propertyName) {
        PropertyFileReader.propertyName = propertyName;
        return this;
    }
    public Properties readProperty() throws IOException {
        Properties prob = new Properties();
        InputStream input = PropertyFileReader.class.getClassLoader().getResourceAsStream(propertyName);
        prob.load(input);
        return prob;
    }
}
