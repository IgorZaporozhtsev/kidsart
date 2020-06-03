package com.zeecoder.kidsart.controller;

import com.zeecoder.kidsart.model.Message;
import com.zeecoder.kidsart.service.MessageService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("message")
public class MessageController {
    private final MessageService messageService;

    @Autowired
    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @GetMapping
    public List<Message> getMessages() {
        return messageService.getAllMessage();
    }

    @GetMapping("/{id}")
    public Optional<Message> getOne(@PathVariable("id") Message message) {
        return messageService.getMessageByID(message.getId());
    }


    @PostMapping
    public Message create(@RequestBody Message message) {
        return messageService.addMessage(message);
    }

    @PutMapping("{id}")
    public Message update(@PathVariable("id") Message messageFromDb, @RequestBody Message message) {
        BeanUtils.copyProperties(message, messageFromDb, "id");
        return messageService.updateMessage(messageFromDb);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable ("id") Message message){
        messageService.deleteMessage(message);
    }
}