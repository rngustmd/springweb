package example.day05;

import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor@AllArgsConstructor@Builder
@Getter@Setter@ToString
public class TestDto { // 서로 다른 계층 간 이동 객체( Controller 에서는 Entity 사용금지 )
    // Entity와 동일하게 멤버변수 구성: 기능별로 DTO 구성, 예] 등록DTO , 조회DTO, 수정DTO
    private Integer no;
    private String name;
    private String ddescc;
    private Integer price;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;

    // DTO -> ENTITY 함수 : C -> S( D -> E ) , toEntity( ) , 주로 save/update
    // this이란? 해당 메소드 호출한 인스턴스 가리킴.
    public TestEntity toEntity( ){
        return TestEntity.builder() // 빌더패턴이란? new(생성자) 대신에 객체생성을 메소드 방식 지원
                .name(this.name)
                .ddescc(this.ddescc)
                .price(this.price)
                .build(); // 빌더패턴 끝
    }
    // Entity -> DTO 함수 : S -> C( E -> D ) , from( Entity entity ) , 주로 find
    // static 이란? 인스턴스 없이 호출가능 메소드/변수
    // static 에는 this 없을까? 인스턴스 없이 사용하는 메소드
    public static TestDto from( TestEntity testEntity ){
        return TestDto.builder() // 빌더 시작 , 순서/개수 상관없이 자유롭게 객체생성가능
                .no( testEntity.getNo() )
                .name( testEntity.getName() )
                .ddescc( testEntity.getDdescc() ) 
                .price( testEntity.getPrice() )
                .createDate( testEntity.getCreateDate() )
                .updateDate( testEntity.getUpdateDate() )
                .build(); // 빌더 끝
    }
    

}
