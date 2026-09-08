package example.Practice4.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import example.Practice4.model.dto.EnrollDto;
import example.Practice4.model.entity.CourseEntity;
import example.Practice4.model.entity.EnrollEntity;
import example.Practice4.model.entity.StudentEntity;
import example.Practice4.model.repository.CourseRepository;
import example.Practice4.model.repository.EnrollRepository;
import example.Practice4.model.repository.StudentRepository;

@Service 
public class EnrollService {
    @Autowired private EnrollRepository enrollRepository;
    @Autowired private StudentRepository studentRepository;
    @Autowired private CourseRepository courseRepository;

    // 1. 수강등록 : FK --> entity
    public boolean enrollWrite( EnrollDto enrollDto ){
        // 1. dto -> entity
        EnrollEntity enrollEntity = enrollDto.toEntity();
        // ** DTO 내 FK 값을 ENTITY으로 변환 **
        Optional<StudentEntity> optional1 = studentRepository.findById(enrollDto.getStudentId());
        Optional<CourseEntity> optional2 = courseRepository.findById(enrollDto.getCourseId());
        if( optional1.isPresent() && optional2.isPresent() ){
            // 학생엔티티 꺼내서 enroll 엔티티에 대입
            StudentEntity studentEntity = optional1.get();
            enrollEntity.setStudentEntity(studentEntity);
            // 과정엔티티 꺼내서 enroll 엔티티에 대입
            CourseEntity courseEntity = optional2.get();
            enrollEntity.setCourseEntity(courseEntity);
            // 2. FK엔티티 대입 후 , entity save
            EnrollEntity savedEntity = enrollRepository.save(enrollEntity);
            if (savedEntity.getEnrollId() >= 1 ) return true;
        }
        return false;
    }

    // 수강 정보 개별조회
    public EnrollDto enrollRead( Integer enrollId ){
        // Optional<> 클래스는 null 예외검사 메소드 제공 , isPresent() 있으면 true/false , orElse( 없을 때 자료 )
        EnrollEntity enrollEntity = enrollRepository.findById(enrollId).orElse(null);
        return EnrollDto.from(enrollEntity);
    }

} // class end
