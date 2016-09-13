package io.benny.chat.http;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Vertx;
import io.vertx.core.http.HttpMethod;
import io.vertx.core.http.HttpServer;
import io.vertx.core.http.HttpServerResponse;
import io.vertx.ext.web.Route;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.handler.CorsHandler;

import java.util.UUID;

/**
 * Created by benny on 9/13/16.
 */
public class HTTPVerticle extends AbstractVerticle {

    private static long count = 0;
    @Override
    public void start() throws Exception {
        Router router = setUpRouter(vertx);
        HttpServer server = vertx.createHttpServer();
        server.requestHandler(router::accept).listen(8888, result -> {
            System.out.println("Server started...");
        });
    }

    private Router setUpRouter(Vertx vertx) {
        Router router = Router.router(vertx);

        router.route().handler(CorsHandler.create("*")
                .allowedMethod(HttpMethod.GET)
                .allowedMethod(HttpMethod.POST)
                .allowedMethod(HttpMethod.OPTIONS)
                .allowedHeader("X-PINGARUNER")
                .allowedHeader("Content-Type"));


        Route getRouter = router.route(HttpMethod.GET, "/chat");
        Route postRouter = router.route(HttpMethod.POST, "/chat");
        Route lastMessageRouter = router.route(HttpMethod.GET, "/chat/lastMessageId");

        getRouter.handler(context -> {
            HttpServerResponse response = context.response();
            response.putHeader("content-type", "text/plain").end(String.valueOf(UUID.randomUUID()));
            System.out.println("UUID sent");
        });

        postRouter.handler(context -> {
            System.out.println("Incoming post " + );
            count++;
        });

        lastMessageRouter.handler(context -> {
            HttpServerResponse response = context.response();
            response.putHeader("content-type", "text/plain").end(String.valueOf(count));
        });

        return router;
    }
}
