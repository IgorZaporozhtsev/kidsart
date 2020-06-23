package com.zeecoder.kidsart.service;

import com.zeecoder.kidsart.model.Message;
import com.zeecoder.kidsart.repository.MessagesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MessageServiceImpl implements MessagesService{

    private final MessagesRepository messagesRepository;

    @Autowired
    public MessageServiceImpl(MessagesRepository messagesRepository) {
        this.messagesRepository = messagesRepository;
    }

    @Override
    public List<Message> getAll(){
        return messagesRepository.findAll();
    }

    @Override
    public Message getById(Long id){
        return messagesRepository.findById(id).get();
    }

    @Override
    public void add(Message message) {
        messagesRepository.save(message);
    }

    @Override
    public void update(Message message) {
        messagesRepository.save(message);
    }

    @Override
    public void delete(Message message) {
        messagesRepository.delete(message);
    }


}
