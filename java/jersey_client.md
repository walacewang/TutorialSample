# gradle

		compile group: 'org.glassfish.jersey.core', name: 'jersey-client', version: '2.25'
		compile group: 'org.glassfish.jersey.media', name: 'jersey-media-json-jackson', version: '2.25'

# java
		ClientConfig config = new ClientConfig();

		Client client = ClientBuilder.newClient(config);

		WebTarget target = client.target(REST_URI);

		String plainAnswer = target.request().accept(MediaType.TEXT_PLAIN).get(String.class);

		/*
		String response = target.path("rest").path("hello").request().accept(MediaType.TEXT_PLAIN).get(Response.class)
				.toString();

		String plainAnswer = target.path("rest").path("hello").request().accept(MediaType.TEXT_PLAIN).get(String.class);
		String xmlAnswer = target.path("rest").path("hello").request().accept(MediaType.TEXT_XML).get(String.class);
		String htmlAnswer = target.path("rest").path("hello").request().accept(MediaType.TEXT_HTML).get(String.class);
		*/

		System.out.println(plainAnswer);
