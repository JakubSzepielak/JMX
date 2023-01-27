package com.itjs.jolokia.Controller;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;
import java.net.UnknownHostException;

@RestController
@Profile("!ssl")
public class HelloController {

    @Value("${spring.profiles.active:}")
    private String profile;
    private String welcomeMessage = "hello world";

    @RequestMapping(value="hello", method=RequestMethod.GET)
    public String sayHello() throws UnknownHostException {
        String ip = InetAddress.getLocalHost().getHostAddress();
        return String.format("%s, i run with profile: %s, and IP: %s", welcomeMessage, profile, ip);
    }

    @RequestMapping(value="hello", method=RequestMethod.POST)
    public void setHello(@RequestBody String hello){
        this.welcomeMessage = hello;
    }
}
