package com.zeecoder.kidsart.service;

import com.zeecoder.kidsart.model.Message;

import java.util.List;

public interface MessagesService {

    List<Message> getAll();
    Message getById(Long id);
    void add(Message message);
    void update(Message message);
    void delete(Message message);
}
