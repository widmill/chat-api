package com.example.chatapi.repository;

import com.example.chatapi.entity.Chat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface ChatRepository extends JpaRepository<Chat, Long> {

    @Query(value = "SELECT c.chat_id, c.chat_name, c.created_at FROM chat c" +
            " JOIN chats_and_users cau on c.chat_id = cau.chat_id" +
            " JOIN chat_user cu on cau.user_id = cu.user_id" +
            " JOIN messages m on cau.chat_id = m.chat_id" +
            " WHERE cu.user_id = :userId" +
            " GROUP BY c.chat_id" +
            " ORDER BY 3 desc"
            , nativeQuery = true)
    List<Chat> findChatsByUserId(Long userId);

    Chat findChatByChatName(String chatName);
}
