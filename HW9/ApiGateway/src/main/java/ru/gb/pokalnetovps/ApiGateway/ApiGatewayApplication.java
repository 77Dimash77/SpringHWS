package ru.gb.pokalnetovps.ApiGateway;

import jdk.jfr.Enabled;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.cloud.gateway.route.RouteLocator;

@SpringBootApplication
@EnableDiscoveryClient
public class ApiGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiGatewayApplication.class, args);
    }

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("UserService", r -> r.path("/users/**")
						.uri("http://localhost:8081/"))
				.route("TaskService",r->r.path("/tasks/**")
						.uri("http://localhost:8082")).build();
    }
}
