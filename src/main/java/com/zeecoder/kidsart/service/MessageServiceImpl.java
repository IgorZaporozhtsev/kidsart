package com.zeecoder.kidsart.service;

import com.zeecoder.kidsart.model.Message;
import com.zeecoder.kidsart.repository.MessagesRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageServiceImpl implements MessagesService{

    private final MessagesRepository messagesRepository;

    public MessageServiceImpl(MessagesRepository messagesRepository) {
        this.messagesRepository = messagesRepository;
    }

    public List<Message> getAllMessages(){
        return messagesRepository.findAll();
    }

    public Message getMessageById(Long id){
        return messagesRepository.getOne(id);
    }


}
