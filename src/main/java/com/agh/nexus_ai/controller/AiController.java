package com.agh.nexus_ai.controller;

import com.agh.nexus_ai.service.AiService;
import jakarta.servlet.http.HttpSession;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ai")
public class AiController {
    private final AiService aiService;

    private final ChatClient chatClient;
    public AiController(AiService aiService, ChatClient chatClient) {
        this.aiService = aiService;
        this.chatClient = chatClient;
    }

    @GetMapping("/chat")
    public String chat(@RequestParam(required = false) String conversationId , HttpSession session
            , @RequestParam String message){
        String sessionId = conversationId != null
                ? conversationId
                : session.getId();
        return aiService.chat(sessionId,message);
    }

    @GetMapping
    public String ask(@RequestParam String message) {

        return chatClient.prompt()
                .user(message)
                .call()
                .content();
    }
}
