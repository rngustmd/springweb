package example.Practice5.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import example.Practice5.model.dto.BoardDto;
import example.Practice5.service.BoradService;
import example.Practice5.service.CommentService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



@RestController 
public class BoardController {
    @Autowired private BoradService boradService;
    @Autowired private CommentService commentService;

    // [1] 게시글 등록 boardWrite()
    @PostMapping("/api/board")
    public boolean boardWrite(@RequestBody BoardDto boardDto) {
        return boradService.boardWrite( boardDto );
    }
    // [2] 게시글 조회 boardRead()
    @GetMapping("/api/board")
    public List<BoardDto> boardRead( ){
        return boradService.boardRead( );
    }
    
    // [3] 게시글 삭제 boardDelete()
    @DeleteMapping("/api/board")
    public boolean boardDelete(
        @RequestParam(name = "id") Integer id ,
        @RequestParam (name = "password") String password ){
        return boradService.boardDelete( id, password);
    }



    

}
