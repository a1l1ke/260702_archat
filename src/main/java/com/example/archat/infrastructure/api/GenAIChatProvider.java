package com.example.archat.infrastructure.api;

import com.example.archat.application.port.ChatProvider;
import com.example.archat.domain.model.Chat;

public class GenAIChatProvider implements ChatProvider {

    @Override
    public String useAI(Chat chat) {
        return ""; // 책임구현
    }

    private GenAIChatProvider() {

    }

    private static final GenAIChatProvider instance = new GenAIChatProvider();

    public static GenAIChatProvider getInstance() {
        return instance;
    }

}
