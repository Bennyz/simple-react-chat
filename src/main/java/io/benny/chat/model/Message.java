package io.benny.chat.model;

/**
 * Created by benny on 9/13/16.
 */
public class Message {
    private int id;
    private String text;
    private String userName;

    public Message() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
