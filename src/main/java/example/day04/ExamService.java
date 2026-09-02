package example.day04;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ExamService {
    private final ExamRepository examRepository;

    // [1] 전체조회
    public List<ExamEntity> findAll( ){
        // 리포지토리 호출
        // 리포지토리객체.findAll() : (구현체) select 지원
        return examRepository.findAll();
    }
    // [2] 저장
    public boolean 저장( ExamEntity entity ){
        // 리포지토리 호출
        // 리포지토리 객체.save( 저장할 entity ) : insert 지원
        // save 반환값은 영속(매핑/저장)된 엔티티 반환
        ExamEntity saved = examRepository.save( entity );
        // 즉] 만약에 SAVE 된 엔티티가 PK가 존재하면 저장 성공
        if( saved.getEno() >= 1 ) return true;
        // PK 가 없으면 저장 실패
        return false;
    }
    // [3] 삭제
    public boolean 삭제 (int no){
        // 리포지토리 호출
        // 리포지토리 객체 .deleteById( 삭제할PK번호 ) : delete SQL 지원
        // 리포지토리 객체 .delete(삭제할 엔티티)
        // 반환타입 : 없음 , 삭제여부 findXXX 이용하여 확인
        examRepository.deleteById( no );
        return true; // 삭제 성공
    }
    // [4] 수정
    @Transactional // 트랜잭션이란? 여러개 SQL 하나의 단위로 묶음
    // 만약에 여러개 SQL 중에 하나라도 SQL오류아면 전체 ROLLBACK(취소) 모두 성공하면 COMMIT(완료)
    // 활용처 : 계좌이체(출금/임금) , 회원가입포인트(회원가입/최초포인트지원) : 2개 이상 기능을 하나로 묶음
    public boolean 수정( ExamEntity entity ){
        // 1. 영속된 엔티티 조회[PK:수정할 번호]
        // 리포지토리객체.findById( 조회할PK번호 ) : select SQL 지원
        // 반환타입 : Optional<ExamEntity>
        // Optional 클래스란? 본문(객체) 감싼 클래스 ( 왜? null 예외 안전하게 사용 )
            // --> 만약에 조회 결과 엔티티가 없을 때 .getEno() 오류가 발생
            // Optional<객체타입> 변수명; 객체 래핑하여 null 검사 지원
        Optional<ExamEntity> optional = 
        examRepository.findById( entity.getEno() );
        // 2. 조회된 결과 엔티티 여부 확인
        if (optional.isPresent() ) { // 객체가 있으면 true , 없으면 false
            ExamEntity savedEntity = optional.get(); // 래핑된 Optinal 에서 엔티티 꺼내기
            // 3. 만약에 엔티티가 존재하면 수정 , update SQL 대신에 setter
            savedEntity.setEname( entity.getEname() );
            return true;
        }
        return false;
    }

}
