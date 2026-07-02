package com.example.archat.domain.repository;

import com.example.archat.domain.model.Chat;

import java.util.List;

public interface ChatRepository {
    // Create, Read. (YAGNI, KISS, DRY)
    // You Ain't Gonna Need It

    void save(Chat chat);

    List<Chat> findAllByUserId(String userId);
}
