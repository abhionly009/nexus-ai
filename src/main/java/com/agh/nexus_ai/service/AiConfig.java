package com.agh.nexus_ai.service;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AiConfig {

        @Bean
        ChatClient chatClient(ChatClient.Builder builder,
                              ProductTools productTools) {

            return builder
                    .defaultTools(productTools)
                    .build();
        }

}
