package example.Practice0918;

import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service 
public class ApiService {

    @Value("${api.public-data.service-key}")

    private String serviceKey;
    
    private WebClient webClient = WebClient.builder().build();

    public Map<String,Object> Koo( ){

        String url = "https://api.odcloud.kr/api/15087697/v1/uddi:b06dcf2d-3b77-4d88-a50f-ede85eb74c3c";
        url += "?page=" + 1;
        url += "&perPage=" + 10;
        url += "&serviceKey=" + serviceKey;

        Map<String,Object> response = webClient.get()
            .uri(url)
            .retrieve( )
            .bodyToMono(Map.class)
            .block( );
        
        return response;
    }
}
