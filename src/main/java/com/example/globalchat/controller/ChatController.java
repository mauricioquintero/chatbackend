package com.example.globalchat.controller;

import com.example.globalchat.model.Message;
import com.example.globalchat.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.time.LocalDateTime;

@CrossOrigin(origins = "http://localhost:3000")
@Controller
public class ChatController {

    @Autowired
    private MessageService messageService;

    @MessageMapping("/chat.sendMessage")
    @SendTo("/topic/public")
    public Message sendMessage(@Payload Message message){
        Message savedMessage = messageService.saveMessage(message);
        return savedMessage;
    }
}
