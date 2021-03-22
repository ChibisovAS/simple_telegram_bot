package com.github.chibisovas.stb.models;

public class User {
    private Long chatID;
    private Long lastArticleID;

    public User(Long chatID) {
        this.chatID = chatID;
    }

    public User(Long chatID, Long lastArticleID) {
        this.chatID = chatID;
        this.lastArticleID = lastArticleID;
    }

    public Long getChatID() {
        return chatID;
    }

    public void setChatID(Long chatID) {
        this.chatID = chatID;
    }

    public Long getLastArticleID() {
        return lastArticleID;
    }

    public void setLastArticleID(Long lastArticleID) {
        this.lastArticleID = lastArticleID;
    }
}
