package com.example.archat.model.repository;

import com.example.archat.domain.model.Chat;
import com.example.archat.domain.repository.ChatRepository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

// 1. ChatRepository로 업캐스팅 -> 의존성 주입
// 2. ChatRepository의 구현 책임을 가져간다 (같은 메서드를 갖고 있다
public class InMemoryChatRepository implements ChatRepository {
    private InMemoryChatRepository() {
    }

    // 이 클래스가 정의될 때 아예 이 클래스의 인스턴스를 생성해서 static으로 얹힘
    // -> 모든 스레드의 공유자원 (톰캣이 서버로 호출하는 모든 것에서 공통적으로 쓰게 됨)
    private static final InMemoryChatRepository instance = new InMemoryChatRepository();

    public static InMemoryChatRepository getInstance() {
        return instance;
    }

    private final ConcurrentHashMap<String, List<Chat>> chatMap = new ConcurrentHashMap<>();

    @Override
    public void save(Chat chat) {
        chatMap.computeIfAbsent( // 특정한 계산을 시킬 건데, 없을 때 해당 계산/대입을 진행
                chat.sessionId(),
                k -> new ArrayList<>()
        ).add(chat);
    }

    @Override
    public List<Chat> findAllByUserId(String userId) {
        return chatMap.getOrDefault(userId, Collections.emptyList());
    }

}
