package ru.gb.gbthymeleaf.config;

import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class KafkaConfig {

    @Bean
    public NewTopic topic() {
        return TopicBuilder.name("gb-topic")
                .partitions(10)
                .replicas(1)
                .build();
    }
}
