package ru.gb.gbthymeleaf.kafka;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Listener {

    @KafkaListener(id = "myId", topics = "gb-topic")
    public void listen(String in) {
        System.out.println(in);
    }
}
