package example.Practice4.model.dto;

import java.time.LocalDateTime;

import example.Practice4.model.entity.StudentEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor @AllArgsConstructor @Builder @Data 
public class StudentDto {
    private Integer studentId;
    private String studentName;
    private LocalDateTime createdAt;
    private LocalDateTime updateAt;

    public StudentEntity toEntity(){
        return StudentEntity.builder()
            .studentName(this.studentName)
            .build();
    }

    public static StudentDto from(StudentEntity studentEntity){
        return StudentDto.builder()
            .studentId(studentEntity.getStudentId())
            .studentName(studentEntity.getStudentName())
            .createdAt(studentEntity.getCreatedAt())
            .updateAt(studentEntity.getUpdatedAt())
            .build();
    }

}
