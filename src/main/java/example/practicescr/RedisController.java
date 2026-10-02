package example.practicescr;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController 
@RequestMapping ("/api/redis")
@RequiredArgsConstructor 
public class RedisController {

    private final RedisService redisService;

    // [1] 저장
    @GetMapping("/add")
    public String redisAdd( @RequestParam String data ) {
        
        return redisService.redisAdd(data);
    
    }

    // [2] 조회
    @GetMapping("/all")
    public List<String> redisAll( ){
        
        return redisService.redisAll();
    }
        

}
