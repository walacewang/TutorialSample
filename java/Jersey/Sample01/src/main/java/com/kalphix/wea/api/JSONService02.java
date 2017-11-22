package com.kalphix.wea.api;

import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;

import com.kalphix.wea.api.bean.UserInfo;

@Path("/weaapi02/{username:[a-zA-Z][a-zA-Z_0-9]*}")
public class JSONService02 {

	private Logger logger = java.util.logging.Logger.getLogger("WeaLogger");
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public UserInfo getUserInfo(@PathParam("username") String userName) {

		UserInfo userInfo = new UserInfo();
		userInfo.setUsername(userName);
		userInfo.setId("2140-3251-2140");
		userInfo.setBirthday(Calendar.getInstance().getTime());
		userInfo.setAddress("ìåãûìsì˙ñ{ã¥ñ{í¨ÇPíöñ⁄ÇPÇOî‘â™ñ{ÉrÉãÇSäK");

		if("ERROR".equals(userName)) {
			
			try {
				int a, b;
				a = 1;
				b = 0;
				a = a / b;
			} catch (Exception ex) {
				logger.log(Level.SEVERE, "ívñΩìIÇ»ïsñæó·äOÇ≈Ç∑ÅB", ex);
				//ex.printStackTrace();
				throw new WebApplicationException(400);
			}
		}
		if("FATAL".equals(userName)) {
			
			int a, b;
			a = 1;
			b = 0;
			a = a / b;
		}
		return userInfo;
		//return Response.status(Status.OK).entity(userInfo).type(MediaType.APPLICATION_JSON).build();

	}

}