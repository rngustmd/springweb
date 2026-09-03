package example.Practice2;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TestService {
    private final TestRepository testRepository;

    // [1] 게시물 등록 testWrite()
    public boolean testWrite( TestEntity entity ){
        TestEntity saved = testRepository.save( entity );
        if( saved.getEno() >= 1 ) return true;
        return false;
    }
    // [2] 게시물 전체조회 testPrint()
    public List< TestEntity > findAll( ){
        return testRepository.findAll( );
    }
    // [3] 게시물 개별조회 testDetail()
    public TestEntity testDetail(int no) {
        // 1. 리포지토리 이용한 select 처리하기 , .findById( pk 번호 )
        // Optional 클래스란? 객체사용시 null 예외 가 발생하는 경우 안전하게 메소드 제공
        Optional<TestEntity> optional = testRepository.findById(no);
        // 2. 포장(Optional) 내 엔티티 들어있어? 조회결과 엔티티 확인
        if( optional.isPresent() ){
            return optional.get(); 
            // 3. 포장 (Optional) 열기 , 엔티티 꺼내기
        }
        return null;
    }

    // [4] 게시물 삭제 testDelete()
    public boolean testDelete( int no ){
        testRepository.deleteById( no );
        return true;
    }
    // [5] 게시물 수정 testUpdate()
    @Transactional
    public boolean testUpdate( TestEntity entity ){
        Optional<TestEntity> optional =
        testRepository.findById( entity.getEno() );
        if (optional.isPresent() ){
            TestEntity savEntity = optional.get();
            savEntity.setEcontent( entity.getEcontent() );
            return true;
        }
        return false;
    }

}
