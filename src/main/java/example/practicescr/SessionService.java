package example.practicescr;

import java.util.List;

import org.springframework.stereotype.Service;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

@Service @RequiredArgsConstructor 
public class SessionService {

    // [1] 저장
    public String sessionadd( String data , HttpSession session ){

        try { 
                                // 이름(key)으로 저장
            Object savedData = session.getAttribute("data");

            if (savedData == null) {

                // 세션 정보 저장
                session.setAttribute("data", data);

                return "세션저장성공";

            }
            
            // 기존 데이터 문자열 변경
            String oldData = savedData.toString();
            // 새로운 데이터 추가 [ apple ] -> [ apple , banana ]
            String newData = oldData + "," + data;

            session.setAttribute("data" , newData);

            return "세션저장성공";

            } catch (Exception e) {

            return "세션저장실패";

        }


    }

    // [2] 조회
    public List<String> sessionAll( HttpSession session ) {

        Object savedData = session.getAttribute("data");

        if (savedData == null) {
            
            return List.of();

        }

        String data = savedData.toString();

        // 쉼표 기준으로 나누기 [ "apple" , "banana" ]
        return List.of(data.split(","));
        
    }



}
