package com.example.archat.application.service;

import com.example.archat.application.port.ChatProvider;
import com.example.archat.domain.model.Chat;
import com.example.archat.domain.repository.ChatRepository;
import com.example.archat.domain.service.ChatService;
import com.example.archat.infrastructure.api.GenAIChatProvider;
import com.example.archat.infrastructure.api.GenAIConfig;
import com.example.archat.infrastructure.repository.InMemoryChatRepository;
import com.google.genai.Client;
import com.google.genai.types.Content;
import com.google.genai.types.GenerateContentResponse;
import com.google.genai.types.Part;

import java.time.ZonedDateTime;
import java.util.List;

public class GeminiChatService implements ChatService {

    private final ChatRepository chatRepository;
    private final ChatProvider chatProvider;

    @Override
    public void save(Chat chat) {
        chatRepository.save(chat);
//        String aiResponse = useAI(chat);
        String aiResponse = chatProvider.useAI(chat);
        Chat aiChat = new Chat(
                aiResponse,
                "AI",
                chat.userId(),
                chat.model(),
                ZonedDateTime.now().toString()
        );
        chatRepository.save(aiChat);
    }

    @Override
    public List<Chat> findAllByUserId(String userId) {
        return chatRepository.findAllByUserId(userId);
    }

    private String useAI(Chat chat) {
        List<Chat> history = chatRepository.findAllByUserId(chat.userId());
        List<Content> contents = history.stream()
                .map((c) -> Content.builder()
                        .role(chat.owner().equals("USER") ? "user" : "model")
                        .parts(Part.builder().text(c.message()).build())
                        .build())
                .toList();
        try (Client client = GenAIConfig.getClient()) {
            GenerateContentResponse response = client.models.generateContent(
                    chat.model(),
                    contents,
                    GenAIConfig.getGenerateContentConfig());
            return response.text();
        } catch (Exception e) {
            e.printStackTrace();
            return "문제가 생겼어요 : %s".formatted(e.getMessage());
        }
    }

    // 싱글톤 등록

    private GeminiChatService() {
        this.chatRepository = InMemoryChatRepository.getInstance();
        this.chatProvider = GenAIChatProvider.getInstance();
    }

    private static final GeminiChatService instance = new GeminiChatService();

    public static GeminiChatService getInstance() {
        return instance;
    }

}
