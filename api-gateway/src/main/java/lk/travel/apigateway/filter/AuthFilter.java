package lk.travel.apigateway.filter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.function.Function;
import java.util.function.Predicate;

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
            System.out.println("Boolean True : "+path);

                if(!exchange.getRequest().getHeaders().containsKey(HttpHeaders.AUTHORIZATION)) {
                    throw new RuntimeException("Unauthorized!! Authorization Header Not available");
                }
                  String token = exchange.getRequest().getHeaders().get(HttpHeaders.AUTHORIZATION).get(0);
                System.out.println("Token : "+token);

                HttpHeaders httpHeaders = new HttpHeaders();
                httpHeaders.set(HttpHeaders.AUTHORIZATION,token);
                ResponseEntity<Boolean> authResponse = restTemplate.exchange("http://localhost:8081/" + path, HttpMethod.GET, new HttpEntity<>(httpHeaders), Boolean.class);
                if (authResponse.getStatusCode().value() > 299) {
                    throw new RuntimeException("Unauthorized..!!");
                }

                if (!authResponse.getBody()) {
                    throw new RuntimeException("Unauthorized..!!");
                }
            }
        return chain.filter(exchange);
        };
    }

    public static class Config{}
}
