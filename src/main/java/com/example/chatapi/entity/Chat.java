package com.example.chatapi.entity;
;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "chat")
public class Chat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long chatId;

    @Column(name = "chat_name")
    private String chatName;

    @Transient
    private List<Long> usersId;

    @Column(name = "created_at")
    @CreationTimestamp
    private Timestamp creationDate;

    public Chat(Long chatId, String chatName, Timestamp creationDate) {
        this.chatId = chatId;
        this.chatName = chatName;
        this.creationDate = creationDate;
    }

    public Chat() {}

    public Long getChatId() {
        return chatId;
    }

    public void setChatId(Long chatId) {
        this.chatId = chatId;
    }

    public String getChatName() {
        return chatName;
    }

    public void setChatName(String chatName) {
        this.chatName = chatName;
    }

    public Timestamp getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Timestamp creationDate) {
        this.creationDate = creationDate;
    }

    public List<Long> getUsersId() {
        return usersId;
    }

    public void setUsersId(List<Long> usersId) {
        this.usersId = usersId;
    }


    @Override
    public String toString() {
        return "Chat{" +
                "chatId=" + chatId +
                ", chatName='" + chatName + '\'' +
                ", usersId=" + usersId +
                ", creationDate=" + creationDate +
                '}';
    }
}
