package com.example.archat.model;

public record Chat(
        String message,
        String owner,
        String sessionId,
        String model,
        String timestamp
        // audit -> 감사. 이 데이터가 제대로 된 데이터를 인지를 시간/관계 등으로 검증.
) {
}
