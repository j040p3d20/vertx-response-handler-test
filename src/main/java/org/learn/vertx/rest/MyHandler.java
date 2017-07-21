package org.learn.vertx.rest;

import io.vertx.core.Vertx;
import io.vertx.ext.web.RoutingContext;

public class MyHandler {
	
	private Vertx vertx;
	
	public MyHandler(Vertx vertx) {
		this.vertx = vertx;
	}
	
	public void save(RoutingContext context) 
	{
		
		new MyAsync().save(h->{
			if(h.succeeded()) {
				System.out.println("success");
			}else {
				System.out.println("failure");
			}
		},vertx.createHttpClient());
	}

}
