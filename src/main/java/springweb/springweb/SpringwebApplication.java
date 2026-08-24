package springweb.springweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringwebApplication {


	// [1] 해당 클래스파일 ctrl+f5 실행 후 , 인터넷 켜고 localhost:8000 접속 후 Error page
	public static void main(String[] args) {
		SpringApplication.run(SpringwebApplication.class, args);
	}

}
