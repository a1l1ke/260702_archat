package com.example.archat.infrastructure.api;

import com.example.archat.application.port.ChatProvider;
import com.example.archat.domain.model.Chat;

import java.util.List;

public class GroqChatProvider implements ChatProvider {

    @Override
    public String useAI(Chat chat) {
        // HttpClient <- Fetch 쓰듯이. or langchain4j.
        throw new RuntimeException("Not Implemented");
    }

    @Override
    public String useAI(Chat newChat, List<Chat> chatHistory) {
        throw new RuntimeException("Not Implemented");
    }

    private GroqChatProvider() {

    }

    private static final GroqChatProvider instance = new GroqChatProvider();

    public static GroqChatProvider getInstance() {
        return instance;
    }

}
