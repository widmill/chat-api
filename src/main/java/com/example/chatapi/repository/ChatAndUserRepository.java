package com.example.chatapi.repository;

import com.example.chatapi.entity.ChatAndUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ChatAndUserRepository extends JpaRepository<ChatAndUser, Long> {

    @Query(value = "SELECT user_id from chats_and_users where chat_id = :chatId", nativeQuery = true)
    List<Long> findAllUserIdByChatId(Long chatId);
}
