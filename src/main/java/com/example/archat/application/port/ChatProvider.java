package com.example.archat.application.port;

import com.example.archat.domain.model.Chat;

import java.util.List;

public interface ChatProvider {
    String useAI(Chat chat);

    // 오버 로딩
    String useAI(Chat newChat, List<Chat> chatHistory);
}
