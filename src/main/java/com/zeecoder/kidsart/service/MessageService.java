package com.zeecoder.kidsart.service;

import com.zeecoder.kidsart.model.Message;
import com.zeecoder.kidsart.repository.MessageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MessageService {

    private final MessageRepo messageRepo;

    @Autowired
    public MessageService(MessageRepo messageRepo) {
        this.messageRepo = messageRepo;
    }

    public List<Message> getAllMessage(){
        return messageRepo.findAll();
    }

    public Optional<Message> getMessageByID(Long id){
        return messageRepo.findById(id);
    }

    public Message addMessage(Message message){
        return messageRepo.save(message);
    }

    public Message updateMessage(Message message){
        return messageRepo.save(message);
    }

    public void deleteMessage(Message message){
        messageRepo.delete(message   );
    }
}
