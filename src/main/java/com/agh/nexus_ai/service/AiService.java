package com.agh.nexus_ai.service;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.MessageChatMemoryAdvisor;
import org.springframework.ai.chat.memory.InMemoryChatMemoryRepository;
import org.springframework.ai.chat.memory.MessageWindowChatMemory;
import org.springframework.stereotype.Service;

import static org.springframework.ai.chat.memory.ChatMemory.CONVERSATION_ID;

@Service
public class AiService {
    private final ChatClient chatClient;

    public AiService(ChatClient.Builder builder,WeatherService weatherService) {


        InMemoryChatMemoryRepository memoryRepository =
                new InMemoryChatMemoryRepository();

        MessageWindowChatMemory memory =
                MessageWindowChatMemory.builder()
                        .chatMemoryRepository(memoryRepository)
                        .maxMessages(10)
                        .build();


        this.chatClient = builder
                .defaultAdvisors(
                        MessageChatMemoryAdvisor.builder(memory).build()
                ).defaultTools(weatherService)
                .build();
    }


    public String chat(String conversationId, String userMessage) {
        return chatClient
                .prompt(userMessage)
                .advisors(advisor -> advisor
                        .param(CONVERSATION_ID, conversationId)
                )
                .call()
                .content();
    }

}
