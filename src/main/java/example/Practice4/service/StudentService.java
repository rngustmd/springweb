package example.Practice4.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import example.Practice4.model.dto.CourseDto;
import example.Practice4.model.dto.StudentDto;
import example.Practice4.model.entity.StudentEntity;
import example.Practice4.model.repository.StudentRepository;

@Service 
public class StudentService {
    @Autowired private StudentRepository studentRepository;

    // [1] 학생 정보 등록
    public boolean studentData( StudentDto studentDto ){
        StudentEntity studentEntity = studentDto.toEntity();
        StudentEntity savedEntity = studentRepository.save( studentEntity );
        if( savedEntity.getStudentId() >= 1){ return true;            
        } return false;
    }

    // [2] 학생 정보 삭제
    // JPA : cascade = CascadeType.REMOVE , SQL : on delete cascade
    public boolean studentDelete( Integer studentId ){
        // 1. 학생번호 이용한 학생엔티티 찾기
        Optional<StudentEntity> optional =
        // 2. 만일 엔티티 존재하면
        studentRepository.findById(studentId);
        if (optional.isPresent() ) {
            studentRepository.delete(optional.get());
            return true;
        }
        return false;
    }

} // class end
