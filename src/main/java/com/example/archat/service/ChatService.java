package com.example.archat.service;

import com.example.archat.model.repository.ChatRepository;
import com.example.archat.model.repository.InMemoryChatRepository;

public class ChatService {
    private final ChatRepository chatRepository;
    public ChatService() {
        // ChatService - InMemoryChatRepository
        // 생성자에서 엮여있긴 함. -> chatRepository을 호출하는 메서드는 InMemoryChatRepository 알아야함?
        // No. 만약 SupabaseChatRepository로 바꾼다면 생성자에서 진행하는 의존성 주입을 바꿔주기만 하면 OK
        this.chatRepository = InMemoryChatRepository.getInstance();
    }
}
