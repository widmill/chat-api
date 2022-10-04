package com.example.chatapi.service;


import com.example.chatapi.entity.Message;
import com.example.chatapi.exception.EntityNotFoundException;
import com.example.chatapi.exception.NullFieldException;
import com.example.chatapi.repository.ChatRepository;
import com.example.chatapi.repository.MessageRepository;
import com.example.chatapi.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {

    private final MessageRepository messageRepository;

    private final UserRepository userRepository;

    private final ChatRepository chatRepository;

    private static final Logger log = LoggerFactory.getLogger(MessageService.class);

    public MessageService(MessageRepository messageRepository, UserRepository userRepository, ChatRepository chatRepository) {
        this.messageRepository = messageRepository;
        this.userRepository = userRepository;
        this.chatRepository = chatRepository;
    }

    public Long sendMessage(Message message) {

        if (message.getChatId() == null || message.getUserId() == null) {

            throw new NullFieldException("Chat id and user id must be filled.");

        }

        if (chatRepository.findById(message.getChatId()).isEmpty()) {
            throw new EntityNotFoundException
                    ("Chat with id " + message.getChatId() + " was not found.");
        }

        if (userRepository.findById(message.getUserId()).isEmpty()) {
            throw new EntityNotFoundException
                    ("User with id " + message.getUserId() + " was not found.");
        }

        messageRepository.save(message);

        log.info("Message successfully sent: {}", message);

        return message.getMessageId();

    }

    public List<Message> getMessages(Long chatId) {

        if (chatId == null) {

            throw new NullFieldException("Chat id must be filled.");
        }

        if (chatRepository.findById(chatId).isEmpty()) {

            throw new EntityNotFoundException("Chat with id " + chatId + " was not found.");
        }

        return messageRepository.findAllByChatIdOrderByCreationDateDesc(chatId);


    }

}
