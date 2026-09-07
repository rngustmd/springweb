package example.Practice4.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import example.Practice4.model.dto.StudentDto;
import example.Practice4.service.StudentService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



@RestController 
@RequestMapping("/api/student")
public class StudentController {
    @Autowired private StudentService studentService;

    // [1] 학생 정보 등록
    @PostMapping("")
    public boolean studentData(@RequestBody StudentDto studentDto) {
        return studentService.studentData( studentDto );
    }

    // [2] 학생 정보 삭제
    @DeleteMapping("")
    public boolean studentDelete(@RequestParam(name = "studentId" ) Integer studentId ){
        return  studentService.studentDelete(studentId);
    }





} // class end
    
    



