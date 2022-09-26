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

    @PostMapping("/add")
    public Long sendMessage(@RequestBody Message message) {

        return messageService.sendMessage(message);

    }

    @PostMapping("/get")
    public List<Message> getMessages(@RequestBody Long chatId) {

        return messageService.getMessages(chatId);

    }
}
