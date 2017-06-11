package rest;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

@Path("/hello")
public class Hello {
	@GET
	public String getMessage() {
		return "Hello Rest";
	}
	@POST
	public void postData(String title) {
		System.out.println("Post request made with title"+title);
	}
	

}
