package com.zeecoder.kidsart.controller;

import com.zeecoder.kidsart.model.Message;
import com.zeecoder.kidsart.service.MessageServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/messages")
public class MessageController {

    @Autowired
    MessageServiceImpl messageService;

    @Value("${upload.path}")
    private String uploadPath;

    @GetMapping
    public List<Message> getAllMessage(){
        return messageService.getAllMessages();
    }

    @GetMapping("/{id}")
    public Message getOne(@PathVariable(name = "id") Long id){
        return messageService.getMessageById(id);
    }

    @PostMapping("/upload")
    public void addFile(@RequestParam("file") MultipartFile file){
        File uploadDir = new File(uploadPath);

        if (!uploadDir.exists()) {
            uploadDir.mkdir();
        }

        String uuidFile = UUID.randomUUID().toString();
        String resultFileName = uuidFile + "." + file.getOriginalFilename();
        try {
            file.transferTo(new File(uploadPath + "/" + resultFileName));
        } catch (IOException e) {
            e.printStackTrace();
        }


    }



}
