package io.benny.chat.data;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.RuntimeJsonMappingException;
import io.benny.chat.model.Message;
import redis.clients.jedis.Jedis;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by benny on 9/13/16.
 */
public class RedisChatService implements ChatService {

    private Jedis jedis;
    private String key;
    private ObjectMapper om;

    public RedisChatService(RedisConnection redisConnection, String key) {
        this.jedis = redisConnection.getConnection();
        this.key = key;
        om = new ObjectMapper();
    }

    @Override
    public void saveMessage(Message message) {
        try {
            jedis.rpush(key, om.writeValueAsString(message));
            jedis.save();
        } catch (JsonProcessingException e) {
            throw new RuntimeJsonMappingException("JSON parsing failed");
        }
    }

    @Override
    public long getLastMessageId(long id) {
        String result = jedis.lindex(key, -1);
        Message message = null;

        try {
            message = om.readValue(result, Message.class);
        } catch (IOException e) {
            throw new RuntimeJsonMappingException("JSON parsing failed");
        }

        return message.getId();
    }

    @Override
    public List<Message> getMessages(int startIndex) {
        List<String> lrange = jedis.lrange(key, startIndex, -1);

        return lrange.stream().map(s -> {
            Message message = null;

            try {
                message = om.readValue(s, Message.class);
            } catch (IOException e) {
                throw new RuntimeJsonMappingException("JSON parsing failed");
            }

            return message;
        }).collect(Collectors.toList());
    }
}
