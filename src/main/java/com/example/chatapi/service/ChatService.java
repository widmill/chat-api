package com.example.chatapi.service;

import com.example.chatapi.entity.Chat;
import com.example.chatapi.entity.ChatAndUser;
import com.example.chatapi.exception.EntityAlreadyExistException;
import com.example.chatapi.exception.EntityNotFoundException;
import com.example.chatapi.exception.NullFieldException;
import com.example.chatapi.repository.ChatAndUserRepository;
import com.example.chatapi.repository.ChatRepository;
import com.example.chatapi.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ChatService {

    private final ChatRepository chatRepository;

    private final ChatAndUserRepository chatAndUserRepository;

    private final UserRepository userRepository;

    private final Logger log = LoggerFactory.getLogger(ChatService.class);

    public ChatService(ChatRepository chatRepository, ChatAndUserRepository chatAndUserRepository, UserRepository userRepository) {
        this.chatRepository = chatRepository;
        this.chatAndUserRepository = chatAndUserRepository;
        this.userRepository = userRepository;
    }


    public Long createChat(Chat chat) {

        if ((chat.getChatName() == null || chat.getChatName().isBlank())
                || (chat.getUsersId() == null || chat.getUsersId().isEmpty())) {

            throw new NullFieldException("Chat name and users' ids must be filled.");

        }

        if (chatRepository.findChatByChatName(chat.getChatName()) != null) {

            throw new EntityAlreadyExistException(
                    "Chat with name " + chat.getChatName() + " already exists.");
        }

        for (Long id : chat.getUsersId()) {

            if (userRepository.findById(id).isEmpty()) {
                throw new EntityNotFoundException("User with id " + id + " was not found.");
            }
        }

        chatRepository.save(chat);

        for (Long userId : chat.getUsersId()) {

            chatAndUserRepository.save(new ChatAndUser(chat.getChatId(), userId));

        }

        log.info("Chat successfully created: {}", chat);

        return chat.getChatId();

    }

    public List<Chat> getChatsByUserId(Long userId) {

        if (userId == null) {

            throw new NullFieldException("Id must be filled.");
        }

        if (userRepository.findById(userId).isEmpty()) {

            throw new EntityNotFoundException("User with id " + userId + " was not found.");
        }

        List<Chat> chats = chatRepository.findChatsByUserId(userId);

        for (Chat chat : chats) {

            chat.setUsersId(chatAndUserRepository.findAllUserIdByChatId(chat.getChatId()));

        }

        return chats;

    }

}
