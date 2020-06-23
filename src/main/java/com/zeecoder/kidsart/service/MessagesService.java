package com.zeecoder.kidsart.service;

import com.zeecoder.kidsart.model.Message;

import java.util.List;

public interface MessagesService {

    List<Message> getAllMessages();
    Message getMessageById(Long id);
}
