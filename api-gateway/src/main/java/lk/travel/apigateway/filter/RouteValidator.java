package lk.travel.apigateway.filter;

import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Predicate;

@Component
public class RouteValidator {
    public static List<String> getPermitRoute(){
        return List.of(
                "api/v1/customer/register",
                "api/v1/hotel/all",
                "api/v1/hotel/search/location/**",
                "api/v1/travel/area/all",
                "api/v1/vehicle/brand/all",
                "api/v1/vehicle/brand/search/**",
                "api/v1/vehicle/category/all"
        );
    }
        public Predicate<String> predicate= path-> getPermitRoute().stream().noneMatch(p-> p.contains(path));

}
