package pl.arkani.springboot.kafka;

import ch.qos.logback.classic.pattern.LineOfCallerConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import pl.arkani.springboot.payload.User;

@Service
public class JsonKafkaConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(JsonKafkaConsumer.class);
    @KafkaListener(topics = "javaguides-json",groupId = "myGroup")
    public void consumer(User user) {
        LOGGER.info(String.format("Json message received -> %s",user.toString()));
    }
}
