package lk.travel.apigateway.filter;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.function.Predicate;

@Component
public class RouteValidator {
    public static List<String> getPermitRoute(){
        return List.of(
                "api/v1/user",
                "api/v1/customer/search",
                "api/v1/customer/register",
                "api/v1/vehicle/brand/search/category",
                "api/v1/vehicle/brand/all",
                "api/v1/vehicle/brand/search/**",
                "api/v1/vehicle/category/all",
                "api/v1/hotel/search",
                "api/v1/hotel/all",
                "api/v1/hotel/search/location/**",
                "api/v1/travel/area/all",
                "api/v1/travel/category"
        );

    }
        public Predicate<String> predicate= path-> getPermitRoute().stream().noneMatch(p-> path.contains(p));

}
