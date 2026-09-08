package example.Practice5.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import example.Practice5.model.dto.CommentDto;
import example.Practice5.service.BoradService;
import example.Practice5.service.CommentService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


@RestController 
public class CommentController {
    @Autowired private CommentService commentService;
    @Autowired private BoradService boradService;

    // [1] 댓글 등록
    @PostMapping("/api/board/comments")
    public boolean commentWrite(@RequestBody CommentDto commentDto) {
        return commentService.commentWrite( commentDto );
    }
    
    // [2] 댓글 삭제
    @DeleteMapping("/api/board/comments")
    public boolean commentDelete(
        @RequestParam (name = "commentId" ) Integer commentId ,
        @RequestParam (name = "password" ) String password ){
            return commentService.commentDelete( commentId , password );
        }

}
