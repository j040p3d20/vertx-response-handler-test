package org.learn.vertx.rest;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.AsyncResult;
import io.vertx.core.Future;
import io.vertx.core.Handler;
import io.vertx.core.http.HttpServerResponse;
import io.vertx.ext.web.Router;

public class App extends AbstractVerticle {

	@Override
	public void start(Future<Void> f) {
		
		// Create a router object.
		Router router = Router.router(vertx);
		
		
		vertx.exceptionHandler(t->{
			System.out.println("vertx exception handler");
			t.printStackTrace();
		});
		
		router.exceptionHandler(t->{
			System.out.println("router exception handler");
			t.printStackTrace();
		});
		
		MyHandler myHandler = new MyHandler(vertx);

		router
		.route("/")
		.handler(myHandler::save);
		
		// Create the HTTP server and pass the "accept" method to the request handler.
		vertx
		.createHttpServer()
		.requestHandler(router::accept)
		.listen(8080);
	}

}
