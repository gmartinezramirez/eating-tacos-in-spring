package com.gmartinezramirez.eatingTacos.controller;

import com.gmartinezramirez.eatingTacos.model.Hello;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

  @GetMapping("/hello")
  public Hello Greeting() {
    return new Hello(1L, "Hello World!");
  }
}
