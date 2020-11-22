package com.mesut.springdemo.restControllers;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestRestController {
    @GetMapping("/test")
    public String test(){
        return "test";
    }
}
