package io.benny.chat;

import io.benny.chat.data.ChatService;
import io.benny.chat.data.RedisChatService;
import io.benny.chat.data.RedisConnection;
import io.benny.chat.http.HTTPVerticle;
import io.vertx.core.Vertx;

/**
 * Created by benny on 9/13/16.
 */
public class Main {
    public static void main(String[] args) {
        Vertx vertx = Vertx.vertx();

        RedisConnection redisConnection = new RedisConnection("localhost", 6379);
        ChatService chatService = new RedisChatService(redisConnection, "messages");
        vertx.deployVerticle(new HTTPVerticle(chatService), result -> {
            if (result.succeeded()) {
                System.out.println("deployed successfully");
            }
        });
    }
}
