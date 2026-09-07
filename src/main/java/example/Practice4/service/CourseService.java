package example.Practice4.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import example.Practice4.model.dto.CourseDto;
import example.Practice4.model.dto.StudentDto;
import example.Practice4.model.entity.CourseEntity;
import example.Practice4.model.repository.CourseRepository;

@Service 
public class CourseService {
    @Autowired private CourseRepository courseRepository;

    // [1] 과정 정보 등록
    public boolean courseData( CourseDto courseDto ){
        CourseEntity courseEntity = courseDto.toEntity();
        CourseEntity savedEntity = courseRepository.save(courseEntity);
        if (savedEntity.getCourseId() >=1 ) { return true;
        } return false;
    }

    // [2] 과정 정보 전체조회
    public List<CourseDto> coursePrint( ){
        // 1. 전체조회 findAll()
        List<CourseEntity> courseEntities = courseRepository.findAll();
        // 2. 전체조회 Entity --> dto변환
        List<CourseDto> courseDtos = new ArrayList<>();
        courseEntities.forEach( (courseEntity) -> {
            CourseDto courseDto = CourseDto.from(courseEntity);
            // *** 과정 DTO에 학생목록 추가 !!! ***
            // * 현재 과정(course) --> 수강기록(enroll)들을 반복하여 --> 구상기록 --> 학생(student)
            courseEntity.getEnrollEntities().forEach( (enroll) -> {
                StudentDto studentDto = StudentDto.from(enroll.getStudentEntity() );
                courseDto.getStudentDtos().add(studentDto);
                });
                courseDtos.add(courseDto); // 2-3 변환된 dto 리스트에 저장
        });
        return courseDtos;
    }




} // class end

