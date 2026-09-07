package example.Practice4.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import example.Practice4.model.repository.EnrollRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController 
@RequestMapping("/api/enroll")
public class EnrollController {
    @Autowired private EnrollRepository enrollRepository;

    // [1] 수강 정보 등록

    
}
