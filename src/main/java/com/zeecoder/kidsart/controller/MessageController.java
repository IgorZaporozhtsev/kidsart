package com.zeecoder.kidsart.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.zeecoder.kidsart.model.Message;
import com.zeecoder.kidsart.model.Views;
import com.zeecoder.kidsart.service.MessageService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("message")
public class MessageController {
    private final MessageService messageService;

    @Autowired
    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @GetMapping
    @JsonView(Views.IdName.class) //show only fields Id, name fields
    public List<Message> getAll() {
        return messageService.getAllMessage();
    }

    @GetMapping("/{id}")
    @JsonView(Views.FullMessage.class)
    public Message getByOne(@PathVariable("id") Message message) {
        return messageService.getMessageByOne(message);
    }


    @PostMapping
    public Message add(@RequestBody Message message) {
        message.setCreationDate(LocalDateTime.now());
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