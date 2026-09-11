package example.day07;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

public class Exam1 {
    public static void main(String[] args) {

        // 서로 다른 클래스의 메소드 호출하는 방법
        // 메소드란? 상호작용( 2개 이상의 개체 주고(인수M)받는(리턴1) ) 
        // 1. 인스턴스 생성하여 메소드 호출
        TestService testService = new TestService();
        int result1 = testService.plus(3, 5);

        // 2. 싱글톤
        // TestService testService = TestService.getInstance();
        // int result2 = testService.plus(3, 5);

        // 3. 메소드가 static이면
        int result3 = TestService.plus2( 10 , 5);

        // 4. 스프링방식:
        // @Component(자동인스턴스생성)@Autowired(인스턴스호출)
        // @Autowired private TestService testService;
        // int result4 = testService.plus(10, 5);
        
        // 인스턴스(주체p) VS static(주체x)
        TestService t1 = new TestService();
        t1.달리기();

        // TestService t2 = new TestService();
        // t2.달리기2();
        // TestService.달리기2();
        // memberDto.toEntity() <---- 현재 dto 인스턴스가
        // MemberDto.from( entity ); < -- 변환할 엔티티

        // 5. 사칙연산( 연산은 하나의 값 반환 )
        int x = 10 + 2 + 5; // 10 + 2 => 12 + 5 => 17

        TestService t3 = new TestService();
        t3.개별호출().밥먹기();


        
    }

}
@Component 
class TestService{

    // private TestService(){}
    // private static final TestService instance = new TestService();
    // public static TestService getInstance(){ return instance; }

    int plus( int x , int y ){
        return x + y;
    }
    static int plus2( int x , int y ){ return x + y;}

    void 달리기(){
        System.out.println( this );
    }
    // static void 달리기2(){
    //     System.out.println( this );
    // }

    List<Student> list = new ArrayList<>();
    TestService( ){
        list.add( new Student("강호동") );
        list.add( new Student("신동엽") );
    }
    Student 개별호출( ){ return list.get(1); }

}

class Student{
    String name;
    void 밥먹기(){
        System.out.println( this.name + "밥 먹는다.");
    }
    Student( String name ){this.name = name;}

}
