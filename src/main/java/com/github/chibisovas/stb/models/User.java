package com.github.chibisovas.stb.models;

public class User {
    private int chatID;
    private int lastArticleID;

    public User(int chatID, int lastArticleID) {
        this.chatID = chatID;
        this.lastArticleID = lastArticleID;
    }

    public int getChatID() {
        return chatID;
    }

    public void setChatID(int chatID) {
        this.chatID = chatID;
    }

    public int getLastArticleID() {
        return lastArticleID;
    }

    public void setLastArticleID(int lastArticleID) {
        this.lastArticleID = lastArticleID;
    }
}
