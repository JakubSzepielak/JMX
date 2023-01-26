package com.itjs.jolokia.Controller;

import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Profile("ssl")
@RestController
@RequestMapping("ssl")
public class HelloSSLController {

    private String welcomeMessage = "hello world";

    @RequestMapping(value="/hello", method= RequestMethod.GET)
    public String sayHello() {
        return "hello World";
    }

    @RequestMapping(value="/hello", method=RequestMethod.POST)
    public void setHello(@RequestBody String hello){
            this.welcomeMessage = hello;
        }

}
