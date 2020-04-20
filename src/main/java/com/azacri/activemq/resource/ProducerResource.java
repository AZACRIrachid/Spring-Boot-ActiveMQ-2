package com.azacri.activemq.resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.jms.Queue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/rest/publish")
public class ProducerResource {

    @Autowired
    private Queue queue;

    @Autowired 
    private JmsTemplate jmsTemplate;


    @GetMapping(value="/{message}")
    public String  publish(@PathVariable("message") final String message) {
        jmsTemplate.convertAndSend(queue, message);

        return "Publishted successfully";
    }


    
    

}