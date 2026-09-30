package example.day10;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository 
public interface MemberRepository extends JpaRepository<MemberEntity , Long> {

    // JPA 사용 시 시본적인 CRUD 메소드 제공 , save findAll findById deleteById 등등
    // * 메소드쿼리(망명규칙) 또는 네이티브쿼리 추가 정의
    // findByXXX : XXX에 필드명 넣어서 조회 추상메소드 만들기

    // mid 이용하여 엔티티 조회
    MemberEntity findByMid(String mid);

    // mname 일치하면 엔티티 조회
    Optional<MemberEntity> findByMname(String mname);


}
