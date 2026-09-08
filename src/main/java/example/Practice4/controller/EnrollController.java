package example.Practice4.controller;

import example.Practice4.service.EnrollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import example.Practice4.model.dto.EnrollDto;
import example.Practice4.model.repository.EnrollRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



@RestController 
@RequestMapping("/api/enroll")
public class EnrollController {
    @Autowired private EnrollService enrollService;

    // [1] 수강 정보 등록
    @PostMapping("")
    public boolean enrollWrite(@RequestBody EnrollDto enrollDto) {
        return enrollService.enrollWrite(enrollDto);
    }

    // [2] 수강 정보 조회
    @GetMapping("")
    public EnrollDto enrollRead(@RequestParam( name = "enrollId" ) Integer enrollId ) {
        return enrollService.enrollRead( enrollId );
    }
    
    
    
}
