package reactive.proxy.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.netty.handler.codec.http.HttpMethod;

@Configuration
public class ReapConfig {

	private static final Logger LOG = LoggerFactory.getLogger(ReapConfig.class);
	
	@Bean
	public RouteLocator routeLocator(RouteLocatorBuilder builder) {

		return builder.routes()
				.route("dummy-route-id", r -> r.method(HttpMethod.GET.toString())
						.and()
						.path("/proxy")
						.filters(fn -> 
						fn.addRequestHeader("request-proxy-header","request-proxy-value")
								.addResponseHeader("response-proxy-header","response-proxy-value")
								.rewritePath("/proxy", "/dummy")
								.circuitBreaker(conf -> 
								conf.setFallbackUri("http://localhost:8090")
								.addStatusCode("500")
								.setRouteId("fallback-route-id")))
						.uri("http://localhost:8080"))
				.build();
	}
}