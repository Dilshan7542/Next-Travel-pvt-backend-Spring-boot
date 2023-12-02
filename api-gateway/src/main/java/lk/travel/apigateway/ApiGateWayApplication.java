package lk.travel.apigateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;


@SpringBootApplication
@EnableDiscoveryClient
public class ApiGateWayApplication{
    public static void main(String[] args) {
        SpringApplication.run(ApiGateWayApplication.class);
    }
    @Bean
    @LoadBalanced
    public WebClient webClient(){
        return WebClient.builder().build();
    }

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

}