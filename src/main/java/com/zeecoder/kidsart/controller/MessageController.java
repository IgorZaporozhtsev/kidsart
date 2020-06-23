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
    public List<Message> getAll(){
        return messageService.getAll();
    }

    @GetMapping("/{id}")
    public Message getOne(@PathVariable(name = "id") Long id){
        return messageService.getById(id);
    }

    @PostMapping
    public void add(@RequestBody Message message){
        messageService.add(message);
    }

    @PutMapping
    public void update(@RequestBody Message message){
        messageService.update(message);
    }

    @DeleteMapping
    public void delete(@RequestBody Message message){
        messageService.delete(message);
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
