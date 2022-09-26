CREATE TABLE chat_user
(
    user_id    SERIAL primary key,
    username   VARCHAR(100) NOT NULL UNIQUE,
    created_at TIMESTAMP    NOT NULL DEFAULT CURRENT_DATE
);


CREATE TABLE chat
(
    chat_id    SERIAL primary key,
    chat_name  VARCHAR(100) NOT NULL UNIQUE,
    created_at TIMESTAMP    NOT NULL DEFAULT CURRENT_DATE
);

CREATE TABLE chats_and_users
(
    id      SERIAL primary key,
    chat_id INTEGER,
    user_id INTEGER
);

CREATE TABLE messages
(
    message_id SERIAL primary key,
    chat_id    INTEGER   NOT NULL REFERENCES chat,
    user_id    INTEGER   NOT NULL REFERENCES chat_user,
    text       TEXT,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_DATE

);
