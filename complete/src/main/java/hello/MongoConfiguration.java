package hello;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.MongoClientURI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MongoConfiguration {

    private static Logger LOG = LoggerFactory.getLogger(MongoConfiguration.class);

    @Bean
    public MongoClient mongo() throws Exception {
        LOG.info("Creating mongo client");
        System.setProperty("javax.net.ssl.trustStore","/Users/abhirampaturu/Abhi/learning/mongo/tls/mongoStore1.jks");
        System.setProperty("javax.net.ssl.trustStorePassword","StorePass");

        System.setProperty ("javax.net.ssl.keyStore","/Users/abhirampaturu/Abhi/learning/mongo/tls/MongoClientKeyCert.p12");
        System.setProperty ("javax.net.ssl.keyStorePassword","test12");

        System.out.println(System.getProperty("javax.net.ssl.trustStore"));

        MongoClientOptions.Builder builder = MongoClientOptions.builder().sslEnabled(true).sslInvalidHostNameAllowed(true);

        MongoClientURI mongoUri = new MongoClientURI("mongodb://localhost/?ssl=true", builder);
        MongoClient mongo = new MongoClient(mongoUri);
        return mongo;
    }

}