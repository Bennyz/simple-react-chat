package io.benny.chat;

import io.benny.chat.http.HTTPVerticle;
import io.vertx.core.Vertx;

/**
 * Created by benny on 9/13/16.
 */
public class Main {
    public static void main(String[] args) {
        Vertx vertx = Vertx.vertx();

        vertx.deployVerticle(HTTPVerticle.class.getName(), result -> {
            if (result.succeeded()) {
                System.out.println("deployed successfully");
            }
        });
    }
}
