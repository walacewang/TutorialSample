package com.kalphix.wea.config;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Feature;

import org.glassfish.jersey.logging.LoggingFeature;
import org.glassfish.jersey.logging.LoggingFeature.Verbosity;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.ServerProperties;

@ApplicationPath("/rest/")
public class WeaApplicationResourceConfig extends ResourceConfig {

	public WeaApplicationResourceConfig() {
		// Register resources and providers using package-scanning.
		packages("com.kalphix.wea");

		// Register my custom provider - not needed if it's in my.package.
		// register(SecurityRequestFilter.class);

		// Register an instance of LoggingFilter.
		// register(new LoggingFilter(LOGGER, true));

		ResourceConfig config = new ResourceConfig(WeaApplicationResourceConfig.class);
		Feature feature = new LoggingFeature(java.util.logging.Logger.getLogger("WeaLogger"), java.util.logging.Level.INFO,
				Verbosity.PAYLOAD_ANY, null);
		config.register(feature);

		// Enable Tracing support.
		property(ServerProperties.TRACING, "ALL");
	}
}