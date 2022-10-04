package com.example.chatapi.controller;

import com.example.chatapi.entity.Message;
import com.example.chatapi.service.MessageService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/messages")
public class MessageController {

    private final MessageService messageService;

    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @PostMapping
    public Long sendMessage(@RequestBody Message message) {

        return messageService.sendMessage(message);

    }

    @GetMapping("/{chatId}")
    public List<Message> getMessages(@PathVariable Long chatId) {

        return messageService.getMessages(chatId);

    }
}
