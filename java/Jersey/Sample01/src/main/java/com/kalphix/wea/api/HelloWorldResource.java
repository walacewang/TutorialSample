package com.kalphix.wea.api;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("hello")
public class HelloWorldResource {
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public AAA sayhello() {
		return new AAA();
		
	}

	class AAA{
		private String a;
		private String b;
		public AAA() {
			a="aaa";
			b="bbb";
		}
		public String getA() {
			return a;
		}
		public void setA(String a) {
			this.a = a;
		}
		public String getB() {
			return b;
		}
		public void setB(String b) {
			this.b = b;
		}
	}
}