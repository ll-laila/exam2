package com.example.order.kafka.config;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;



@Configuration
public class KafkaTransactionTopicConfig {

    @Bean
    public NewTopic borrowTopic() {
        return TopicBuilder
                .name("order-topic")
                .build();
    }


}
