package com.capstone.consumer;



import com.capstone.model.Product;
import com.capstone.serde.JsonDeserializer;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.time.Duration;
import java.util.Arrays;
import java.util.Properties;


public class CapstoneConsumer {
    final String kafkaTopic ="products";




    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Logger logger = LoggerFactory.getLogger(CapstoneConsumer.class.getName());

        String bootstrapServers = "localhost:9092";
        String groupId = "my-grp1";
        String topic = "products";

        // create consumer configs
        Properties properties = new Properties();
        properties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        properties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        properties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
        properties.put(JsonDeserializer.VALUE_CLASS_NAME_CONFIG, Product.class);
        properties.put(ConsumerConfig.GROUP_ID_CONFIG, groupId);
        properties.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");

        // create consumer
        KafkaConsumer<String, Product> consumer = new KafkaConsumer<>(properties);

        // subscribe consumer to our topic(s)
        consumer.subscribe(Arrays.asList(topic));

        // poll for new data
        while (true) {
            ConsumerRecords<String, Product> records =
                    consumer.poll(Duration.ofMillis(100)); // new in Kafka 2.0.0
            String driver ="com.mysql.jdbc.Driver";
            String url = "jdbc:mysql:/.localhost:3306/product";

            Class.forName(driver);
            Connection conn = DriverManager.getConnection(url,"root","root");



            for (ConsumerRecord<String, Product> record : records) {
                logger.info("Key: " + record.key() + ", Value: " + record.value());
                logger.info("Partition: " + record.partition() + ", Offset:" + record.offset());
                String pogId =record.value().getPogId();
                String supc = record.value().getSupc();
                Double price = record.value().getPrice();
                Integer quantity = record.value().getQuantity();

                //insert into mysql db product table ,considering PrimaryKey = PogId
                //As not clearly mentioned in the requirement otherwise update query logic
                //can also be written

                String qry="insert into product(pogId,supc,price,quantity) values(?,?,?,?)";
                PreparedStatement pstmt = conn.prepareStatement(qry);
                pstmt.setString(1,pogId);
                pstmt.setString(2,supc);
                pstmt.setDouble(3,price);
                pstmt.setInt(4,quantity);
                pstmt.executeUpdate(qry);

            }



        }
    }
}
