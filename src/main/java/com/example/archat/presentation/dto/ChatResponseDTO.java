package com.example.archat.presentation.dto;

import com.example.archat.domain.model.Chat;

public record ChatResponseDTO(
        String owner,
        String model,
        String message,
        String timestamp
) {
    // getter -> el parser
    public String getOwner() {
        return owner;
    }

    public String getModel() {
        return model;
    }

    public String getMessage() {
        return message;
    }

    public String getTimestamp() {
        return timestamp;
    }

    // DTO에 변환 로직을 내장 (DTO -> Model(Entity))
    static public ChatResponseDTO of(Chat chat) {
        return new ChatResponseDTO(
                chat.owner(),
                chat.model(),
                chat.message(),
                chat.timestamp()
        );
    }
}
