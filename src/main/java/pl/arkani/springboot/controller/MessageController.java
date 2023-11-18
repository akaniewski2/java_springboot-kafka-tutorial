package pl.arkani.springboot.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.arkani.springboot.kafka.KafkaProducer;

@RestController
@RequestMapping("/api/v1/kafka")
public class MessageController {

    private KafkaProducer kafkaProducer;

    public MessageController(KafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }


    //http:localhost:8080/api/v1/kafka/publish?message=hello world
    @GetMapping("publish")
    public ResponseEntity<String> publish(@RequestParam("message")  String messaage) {

      kafkaProducer.sendMessage(messaage);
      return ResponseEntity.ok("Message sent to the topic");
    }


}
