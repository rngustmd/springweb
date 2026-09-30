package example.day12;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping ("/api/redis")
@RequiredArgsConstructor 
public class RedisController {

    // [1] 레디스 조작 객체 (문자열 기반의 자료 레디스에 삽입/조회/수정/삭제)
    private final StringRedisTemplate stringRedisTemplate;

    // 1. 
    @GetMapping("/test1")
    public List<Map<String , Object>> test1(){
        stringRedisTemplate.opsForValue().set("유재석" , 90 );
    }
    

    

}
