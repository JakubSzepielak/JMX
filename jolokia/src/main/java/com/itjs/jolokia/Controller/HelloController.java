package com.itjs.jolokia.Controller;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Profile("!ssl")
public class HelloController {

    @Value("${spring.profiles.active:}")
    private String profile;
    private String welcomeMessage = "hello world";

    @RequestMapping(value="hello", method=RequestMethod.GET)
    public String sayHello() {
        return "hello World, i rune with profile: " + profile;
    }

    @RequestMapping(value="hello", method=RequestMethod.POST)
    public void setHello(@RequestBody String hello){
        this.welcomeMessage = hello;
    }
}
