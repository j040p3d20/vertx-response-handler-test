package org.learn.vertx.rest;

import io.vertx.core.AsyncResult;
import io.vertx.core.Future;
import io.vertx.core.Handler;
import io.vertx.core.http.HttpClient;

public class MyAsync {

	public void getToken(Handler<AsyncResult> h,HttpClient httpClient) {
		httpClient
		.get(80, "vertx.io", "/")
		.exceptionHandler(xh->{
			xh.printStackTrace();
		})
//		.setTimeout(1000)
		.handler(getHandler->{
			if (getHandler.statusCode() < 300 ) {
				getHandler.bodyHandler(bodyHandler->{
					h.handle(Future.succeededFuture());
				});
			}
		})
		.end();
		
	}
	
	public void save(Handler<AsyncResult> h,HttpClient httpClient) {
		getToken(asyncResult->{
			if(asyncResult.succeeded()) {
				update(h);
			} else {
				h.handle(Future.failedFuture("no token for you"));
			}
		}, httpClient);
	}
	
	private void update(Handler<AsyncResult> h) {
		String s = null;
		if (s.isEmpty()) {
			h.handle(Future.failedFuture("s was empty"));
		} else {
			h.handle(Future.succeededFuture("s not was empty"));
		}
	}
}
