package example.day04;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table( name = "exam" ) // 매핑할 (DB) 테이블의 이름 정의
@Data
@NoArgsConstructor @AllArgsConstructor @Builder
public class ExamEntity {
    // 엔티티는 무조건 1개 이상의 PK 갖는다.
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY ) // auto_increment 지원 = mysql
    private Integer eno;
    private String ename;
}
