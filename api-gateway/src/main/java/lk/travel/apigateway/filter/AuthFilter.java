package lk.travel.apigateway.filter;


import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Component
public class AuthFilter extends AbstractGatewayFilterFactory<AuthFilter.Config> {

    @Autowired
    private RouteValidator routeValidator;
    @Autowired
    private RestTemplate restTemplate;


    public AuthFilter(){
        super(Config.class);
    }
    @Override
    public GatewayFilter apply(Config config) {
        return (exchange, chain) -> {
            String path = exchange.getRequest().getURI().getPath().split("/",3)[2];
            System.out.println("request acrept test : "+path);
            if(routeValidator.predicate.test(path)){

                if(!exchange.getRequest().getHeaders().containsKey(HttpHeaders.AUTHORIZATION)) {
                    throw new RuntimeException("Unauthorized!! Authorization Header Not available");
                }
                  String token = exchange.getRequest().getHeaders().get(HttpHeaders.AUTHORIZATION).get(0);
                System.out.println("Toeken : "+token);

                HttpHeaders httpHeaders = new HttpHeaders();
                httpHeaders.set(HttpHeaders.AUTHORIZATION,token);
                ResponseEntity<Boolean> authResponse = restTemplate.exchange("http://localhost:8081/" + path, HttpMethod.GET, new HttpEntity<>(httpHeaders), Boolean.class);
                if (authResponse.getStatusCode().value() > 299) {
                    throw new RuntimeException("Unauthorized..!!");
                }

                if (!authResponse.getBody()) {
                    throw new RuntimeException("Unauthorized..!!");
                }
                exchange.getResponse().getHeaders().set(HttpHeaders.AUTHORIZATION,authResponse
                        .getHeaders().get(HttpHeaders.AUTHORIZATION).get(0));

            }
        return chain.filter(exchange);
        };
    }

    public static class Config{}
}
