package example.Practice2;

import example.Practice2.TestService;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;




@RestController
@RequiredArgsConstructor

public class TestController {
    private final TestService testService;

    // [1] 게시물 등록 testWrite()
    @PostMapping("/test")
    public boolean testWrite( @RequestBody TestEntity entity ){
        return testService.testWrite( entity );
    }
    
    
    // [2] 게시물 전체조회 testPrint()
    @GetMapping("/test")
    public List< TestEntity > findAll( ){
        return testService.findAll( );
    }
    
    // [3] 게시물 개별조회 testDetail()
    @GetMapping("/test/{no}")
    public TestEntity testDetail(@PathVariable(name = "no") int no) {
        return testService.testDetail(no);
    }
    
    
    // [4] 게시물 삭제 testDelete()
    @DeleteMapping("/test")
    public boolean testDelete( @RequestParam( name = "no" ) int no ){
        return testService.testDelete( no );
    }
    // [5] 게시물 수정 testUpdate()
    @PutMapping("/test")
    public boolean testUpdate( @RequestBody TestEntity entity ){
        return testService.testUpdate( entity );
    }

}
