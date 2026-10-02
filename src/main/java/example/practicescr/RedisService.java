package example.practicescr;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service 
@RequiredArgsConstructor 
public class RedisService {

    private final StringRedisTemplate redisTemplate;

    // [1] 저장
    public String redisAdd( String data ){

        try{ 

            // 레디스에 자료 삽입 , .opsForValue().set( )
            redisTemplate.opsForValue().set(data, data);

            return "레디스저장성공";

        } catch (Exception e){

            return "레디스저장실패";

        }

    }

    // [2] 조회
    public List<String> redisAll( ){

        Set<String> keys = redisTemplate.keys("*");

        List<String> list = new ArrayList<>();

        if (keys == null) {
            
            return list;

        }

        for (String key : keys) {

            String data = redisTemplate.opsForValue().get(key);

            list.add(data);
            
        }

        return list;

    }

}
