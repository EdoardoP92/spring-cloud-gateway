package reactive.proxy.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ReapConfig {

	@Bean
	public RouteLocator routeLocator(RouteLocatorBuilder builder) {

		return builder.routes()
				.route("dummy-service-id", r -> r.path("/dummy")
						.and()
						.path("/dummy")
						.filters(f -> f.addRequestHeader("my-header","my-header-value"))
						.uri("http://localhost:8090"))
				.build();
	}
}
