package edu.iu.P565.customerservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class homeController {
    @GetMapping
    public String greeting(){
        return "Hello!!";
    }
}