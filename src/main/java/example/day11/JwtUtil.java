package example.day11;

import java.nio.charset.StandardCharsets;
import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import jakarta.annotation.PostConstruct;

@Component // SPRING MVC 패턴 객체가 아닌 일반 객체(빈) 생성
public class JwtUtil {

    @Value("${jwt.secret}") // @Value("${propertis파일내속성명}")
    private String key;

    // sha알고리즘 + 비밀키 (임의로) 조합 -> hmacSha
    private SecretKey secretKey;

    @PostConstruct 
    public void init(){
        this.secretKey = Keys.hmacShaKeyFor( key.getBytes( StandardCharsets.UTF_8 ) );
    }

    // [1] JWT 토큰 생성 메소드 
    public String createToken( Long mno ){
        String jwt = Jwts.builder( ) // 토큰 생성 시작
                    .subject( mno+"") // 토큰에 들어갈 내용들( 주로 식별번호 , 권한 )
                    .issuedAt( new Date() ) // 토큰 생성 시간
                    .expiration( new Date( new Date().getTime() + 60 + 60 )) // 토큰 만료 시간
                    // new Date() 현재시간 , new Date().get Time() 현재시간초 , * 60(1분) * 60 (1시간)
                    .signWith(secretKey) // 비밀키로 전자서명
                    .compact( ); // 토큰 생성 끝 , 토큰정보 문자열로 반환
        System.out.println( jwt );
        return jwt;
    }

    // [2] JWT 토큰 검증 메소드 
    public Long getMnoFromToken( String token ){
        try{
            Claims claims = Jwts.parser() // 파싱
                            .verifyWith( secretKey ) // 전자서명 이용한 검증
                            .build()
                            .parseSignedClaims(token) // 파싱할 토큰
                            .getPayload(); // JWT 안에 3단계 ( )
            Long mno = Long.parseLong(claims.getSubject()); // payload 안에 subject 꺼내기 (문자열 --> Long타입)
            System.out.println(mno);
            return mno;
        }catch( Exception e ){
            return null; // 만약에 토큰
        }
    }

}
