package example.Practice4.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import example.Practice4.model.dto.CourseDto;
import example.Practice4.service.CourseService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



@RestController 
@RequestMapping("/api/course")
public class CourseController {
    @Autowired private CourseService courseService;

    // [1] 과정 정보 등록
    @PostMapping("")
    public boolean courseData(@RequestBody CourseDto courseDto) {
        return courseService.courseData( courseDto );
    }

    // [2] 과정 정보 전체조회
    @GetMapping("")
    public List<CourseDto> coursePrint(){
        return courseService.coursePrint();
    }


    

}
