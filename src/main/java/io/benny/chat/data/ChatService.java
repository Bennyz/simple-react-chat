package io.benny.chat.data;

import io.benny.chat.model.Message;

import java.util.List;

/**
 * Created by benny on 9/13/16.
 */
public interface ChatService {
    void saveMessage(Message message);
    long getLastMessageId(long id);
    List<Message> getMessages(int startIndex);
}
