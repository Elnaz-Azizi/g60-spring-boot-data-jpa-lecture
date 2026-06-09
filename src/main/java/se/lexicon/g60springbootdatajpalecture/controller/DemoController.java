package se.lexicon.g60springbootdatajpalecture.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;


@RestController
public class DemoController {

    @GetMapping("/api/v1/demo")
    public ResponseEntity<String> index() {
        System.out.println("### index method called ###");
        String responseBody = "Hello World!";
        return ResponseEntity.ok(responseBody); //200
    }


}
