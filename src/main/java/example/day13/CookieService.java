package example.day13;

import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseCookie;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

@Service @RequiredArgsConstructor 
public class CookieService {

    private final ObjectMapper objectMapper = new ObjectMapper();

    // [1] 저장 
    public String cookieAdd ( String data ,
        String savedData , HttpServletResponse response ) {

            try{

                List<String> list;

                if (savedData == null) {

                    list = new ArrayList<>();
                
                } else { 
                    
                    String decodedData = URLDecoder.decode(savedData, StandardCharsets.UTF_8);
                    
                    list = objectMapper.readValue(decodedData, List.class);
                
                } 

                list.add(data);

                String json = objectMapper.writeValueAsString(list);

                String encodedData = URLEncoder.encode(json , StandardCharsets.UTF_8);

                ResponseCookie cookie = ResponseCookie.from("data" , encodedData)
                    .path("/")
                    .build();

                response.addHeader(HttpHeaders.SET_COOKIE, cookie.toString());

                return "쿠키저장성공";

            } catch (Exception e) {

                return "쿠키저장실패";

            }

        }

    public List<String> cookieAll( String savedData ){

        try{ 

            if ( savedData == null ) {
                
                return List.of(); 
            
            } 

            String decodedData = URLDecoder.decode(savedData , StandardCharsets.UTF_8);

            return objectMapper.readValue(decodedData, List.class);

        } catch (Exception e) {

            return List.of();
        
        }
        
    }

}