package se.lexicon.g60springbootdatajpalecture.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping("/api/v1/demo")
public class DemoController {

    @GetMapping
    public ResponseEntity<String> index() {
        System.out.println("### index method called ###");
        String responseBody = "Hello World!";
        return ResponseEntity.ok(responseBody); //200
    }

    @PostMapping
    /*public ResponseEntity <Map<String, Object>> create() {
        System.out.println("### create method called ###");
        Map<String, Object> responseBody = new HashMap<>();
        responseBody.put("id", 1);
        responseBody.put("name","Student Name");
        responseBody.put("createDate", LocalDate.now());
        return ResponseEntity.status(HttpStatus.CREATED).body(responseBody);}*/

        /*
        id: 1
        name: "Student Name"
        createDate: 2026-06-09
        */

    public ResponseEntity <Map<String, Object>> create(@RequestBody Map<String, Object> requestBody) {
        System.out.println("### create method called ###");
        Map<String, Object> responseBody = new HashMap<>();
        responseBody.put("id", 1);
        responseBody.put("name", requestBody.get("name"));
        responseBody.put("age", requestBody.get("age"));
        responseBody.put("createDate", LocalDate.now());
        return ResponseEntity.status(HttpStatus.CREATED).body(responseBody);

    }
}
