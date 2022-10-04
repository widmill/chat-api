package com.example.chatapi.controller;


import com.example.chatapi.entity.Chat;
import com.example.chatapi.service.ChatService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/chats")
public class ChatController {

    private final ChatService chatService;

    public ChatController(ChatService chatService) {
        this.chatService = chatService;
    }

    @PostMapping
    public Long createChat(@RequestBody Chat chat) {

        return chatService.createChat(chat);

    }

    @PostMapping("/{userId}")
    public List<Chat> getChatsByUserId(@PathVariable Long userId) {

        return chatService.getChatsByUserId(userId);

    }
}
