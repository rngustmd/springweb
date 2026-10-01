package example.day13;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController 
@RequestMapping ("/api/session")
@RequiredArgsConstructor 
public class SessionController {

    private final SessionService sessionService;

    // [1] 저장
    @GetMapping("/add")
    public String add( @RequestParam String data , HttpSession session ){

        return sessionService.sessionadd(data , session);

    }
    
    // [2] 조회
    @GetMapping("/all")
    public List<String> sessionAll( HttpSession session ) {
        return sessionService.sessionAll(session);
    }
    


}
