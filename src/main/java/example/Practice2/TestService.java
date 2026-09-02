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
        Optional<TestEntity> optional = testRepository.findById(no);
        if( optional.isPresent() ){
            return optional.get();
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
