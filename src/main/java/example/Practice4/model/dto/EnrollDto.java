package example.Practice4.model.dto;

import java.time.LocalDateTime;

import example.Practice4.model.entity.EnrollEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor @AllArgsConstructor @Builder @Data 
public class EnrollDto {
    private Integer enrollId;
    private String status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    // 자바(JPA) 에서 entity 로 FK 사용하지만 입력받을 경우 FK 번호 받는다.
    private Integer courseId;
    private Integer studentId;
    // + 과정명, 학생명
    private String courseName;
    private String studentName;

    public EnrollEntity toEntity(){
        return EnrollEntity.builder()
        .status(this.status)
        .build();
    }


    public static EnrollDto from( EnrollEntity enrollEntity ){
        return EnrollDto.builder()
            .enrollId(enrollEntity.getEnrollId())
            .status(enrollEntity.getStatus())
            // 과정엔티티내 과정명만 조회
            .courseName(enrollEntity.getCourseEntity().getCourseName())
            // 학생엔티티내 학생명만 조회
            .studentName(enrollEntity.getStudentEntity().getStudentName())    
            .build();   
        }


}
