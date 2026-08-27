package example.day02Practice.controller;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam; // import 추가
import org.springframework.web.bind.annotation.RestController;

import example.day02Practice.model.dao.WaitingDao;
import example.day02Practice.model.dto.WaitingDto;
/*
    컨트롤러에 서블릿( HTTP 프로토콜 사용 가능하게 기능/방법( GET / POST / PUT / DELETE ) 제공하는 클래스 ) 기능 
    * 레거시(과거) 코드는 상속받아 서블릿 구현
    * 스프링은 @Controller 포함
    // 1. 웹기술 포함할 컨트롤러 클래스 위에 @Controller 또는 반환타입이 JSON이면 @RestController
        * HTTP content type: http 전송 데이터 타입 명시
        text/html , application/json(@RestController) , form 등등 (DTO는 없다.)
    // 2. 해당 메소드 마다의 URL 정의
        * URL 정의시 http://127.0.0.1:8080(도메인) 이후 경로(path/url) 정의 , 중복없이 아무거나!
        1. PostMapping( "/URL" ) : HTTP 메소드 중에 POST 메소드 매핑/연결/대응 어노테이션
*/


 	
@RestController
public class WaitingController {
    private WaitingDao wd = WaitingDao.getInstance();

    // [1] 등록
    @PostMapping( "/waiting/save" )
    public boolean save( WaitingDto waitingDto ){
        boolean result = wd.save(waitingDto);
        return result;
    }

    // [2] 전체조회
    @GetMapping( "/waiting/findall" )
    public ArrayList<WaitingDto> findAll( ){
        ArrayList<WaitingDto> result = wd.findAll();
        return result;
    }

    // [3] 개별수정
    @PutMapping( "/waiting/update" )
    public boolean update( WaitingDto waitingDto ){
        return wd.update(waitingDto);
    }

    // [4] 개별삭제
    @DeleteMapping( "/waiting/delete" )
    public boolean delete( @RequestParam("no") int no ){
        return wd.delete(no);
    }
}