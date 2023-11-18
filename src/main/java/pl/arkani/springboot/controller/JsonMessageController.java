package pl.arkani.springboot.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.arkani.springboot.kafka.JsonKafkaProducer;
import pl.arkani.springboot.payload.User;

@RestController
@RequestMapping("/api/v1/kafka")
public class JsonMessageController {

    private JsonKafkaProducer kafkaProducer;


    public JsonMessageController(JsonKafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    @PostMapping ("/publish")
    public ResponseEntity<String> publish(@RequestBody User user) {
        kafkaProducer.sendMessage(user);
        return ResponseEntity.ok("Json message sent to kafka topic");

    }
}
//http://localhost:8080/api/v1/kafka/publish
//    {
//        "id":1,
//            "firstName": "imie 1",
//            "lastName" :"nazwisko 1"
//
//
//    }