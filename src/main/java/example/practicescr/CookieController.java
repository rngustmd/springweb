package example.practicescr;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



@RestController 
@RequestMapping ("/api/cookie")
@RequiredArgsConstructor 
public class CookieController {

    private final CookieService cookieService;

    // [1] 누적 저장
    // @CookieValue( value="쿠키명") ){ // 요청한 브라우저의 쿠키 가져오기
    @GetMapping("/add")
    public String cookieAdd(@RequestParam String data ,

        @CookieValue( value = "data" , required = false ) String savedData ,
        
        HttpServletResponse response ) {

            return cookieService.cookieAdd(data, savedData, response);

        }
    
    // [2] 조회
    @GetMapping("/all")
    public List<String> cookieAll( 
        @CookieValue(value = "data" , required = false ) String savedData ) {

            return cookieService.cookieAll(savedData);

        }

}
