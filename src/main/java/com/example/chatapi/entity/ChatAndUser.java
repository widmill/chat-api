package com.example.chatapi.entity;

import javax.persistence.*;

@Entity
@Table(name = "chats_and_users")
public class ChatAndUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "chat_id")
    private Long chatId;

    @Column(name = "user_id")
    private Long userId;

    public ChatAndUser(Long chatId, Long userId) {
        this.chatId = chatId;
        this.userId = userId;
    }

    public ChatAndUser() {}

    public Long getChatId() {
        return chatId;
    }

    public void setChatId(Long chatId) {
        this.chatId = chatId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "ChatAndUser{" +
                "chatId=" + chatId +
                ", userId=" + userId +
                '}';
    }
}
