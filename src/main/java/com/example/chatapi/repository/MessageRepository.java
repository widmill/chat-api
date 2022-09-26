package com.example.chatapi.repository;

import com.example.chatapi.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MessageRepository extends JpaRepository<Message, Long> {

    List<Message> findAllByChatIdOrderByCreationDateDesc(Long chatId);
}
