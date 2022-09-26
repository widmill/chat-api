package com.example.chatapi.entity;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "messages")
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long messageId;

    @JoinColumn(name = "chat_id")
    private Long chatId;

    @JoinColumn(name = "user_id")
    private Long userId;

    @Column(name = "text")
    private String text;

    @Column(name = "created_at")
    @CreationTimestamp
    private Timestamp creationDate;

    public Message(Long chatId, Long userId, String text) {
        this.chatId = chatId;
        this.userId = userId;
        this.text = text;
    }

    public Message() {
    }

    public Long getMessageId() {
        return messageId;
    }

    public void setMessageId(Long messageId) {
        this.messageId = messageId;
    }

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

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Timestamp getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Timestamp creationDate) {
        this.creationDate = creationDate;
    }

    @Override
    public String toString() {
        return "Message{" +
                "messageId=" + messageId +
                ", chatId=" + chatId +
                ", userId=" + userId +
                ", text='" + text + '\'' +
                ", creationDate=" + creationDate +
                '}';
    }
}
