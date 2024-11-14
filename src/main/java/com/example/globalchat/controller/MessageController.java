package com.example.globalchat.controller;

import com.example.globalchat.model.Message;
import com.example.globalchat.repository.MessageRepository;
import com.example.globalchat.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/messages")
public class MessageController {

    @Autowired
    private MessageRepository messageRepository;

    @Autowired
    private MessageService messageService;

    @GetMapping
    public List<Message> getAllMessages() {
        return messageService.getAllMessages();
    }

    @PostMapping
    public Message sendMessage(@RequestBody Message message, Authentication authentication) {
        message.setSender(authentication.getName());
        message.setTime(LocalDateTime.now());
        return messageRepository.save(message);
    }
}
