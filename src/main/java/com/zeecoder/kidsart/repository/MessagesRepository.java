package com.zeecoder.kidsart.repository;

import com.zeecoder.kidsart.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessagesRepository extends JpaRepository<Message, Long> {

}
