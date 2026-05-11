package com.agh.nexus_ai.controller;

import com.agh.nexus_ai.service.AiService;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ai")
public class AiController {
    private final AiService aiService;

    public AiController(AiService aiService) {
        this.aiService = aiService;
    }

    @GetMapping("/chat")
    public String chat(@RequestParam(required = false) String conversationId , HttpSession session
            , @RequestParam String message){
        String sessionId = conversationId != null
                ? conversationId
                : session.getId();
        return aiService.chat(sessionId,message);
    }
}
