package com.example.archat.application.port;

import com.example.archat.domain.model.Chat;

public interface ChatProvider {
    String useAI(Chat chat);
}
