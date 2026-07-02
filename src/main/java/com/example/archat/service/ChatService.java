package com.example.archat.service;

import com.example.archat.model.repository.ChatRepository;
import com.example.archat.model.repository.InMemoryChatRepository;

public class ChatService {
    private final ChatRepository chatRepository;
    public ChatService() {
        // ChatService - InMemoryChatRepository
        // 생성자에서 엮여있긴 함. -> chatRepository을 호출하는 메서드는 InMemoryChatRepository 알아야함?
        this.chatRepository = InMemoryChatRepository.getInstance();
    }
}
