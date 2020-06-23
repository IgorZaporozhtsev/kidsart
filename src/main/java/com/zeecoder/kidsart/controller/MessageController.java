package com.zeecoder.kidsart.controller;

import com.zeecoder.kidsart.model.Message;
import com.zeecoder.kidsart.service.MessageServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/messages")
public class MessageController {

    @Autowired
    MessageServiceImpl messageService;

    @GetMapping
    public List<Message> getAllMessage(){
        return messageService.getAllMessages();
    }

    @GetMapping("/id")
    public Message getOne(@PathVariable(name = "id") Long id){
        return messageService.getMessageById(id);
    }

}
