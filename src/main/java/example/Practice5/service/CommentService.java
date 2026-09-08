package example.Practice5.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import example.Practice5.model.dto.CommentDto;
import example.Practice5.model.entity.BoardEntity;
import example.Practice5.model.entity.CommentEntity;
import example.Practice5.model.repository.BoardRepository;
import example.Practice5.model.repository.CommentRepository;

@Service 
public class CommentService {
    @Autowired private CommentRepository commentRepository;
    @Autowired private BoardRepository boardRepository;

    // [1] 댓글 등록
    public boolean commentWrite( CommentDto commentDto ){
        CommentEntity commentEntity = commentDto.toEntity();
        BoardEntity boardEntity = boardRepository.findById( commentDto.getBoardId()).orElse(null);
        commentEntity.setBoardEntity(boardEntity);
        CommentEntity savedEntity = commentRepository.save(commentEntity);
        if (savedEntity.getId() >= 1 ) return true;
        return false;
    }

    // [2] 댓글 삭제
    public boolean commentDelete( Integer commentId , String password ){
        CommentEntity commentEntity = commentRepository.findById(commentId).orElse(null);
        if (commentEntity != null ) {
            if(commentEntity.getPassword().equals(password)){
                commentRepository.deleteById(commentId);
            return true; }
        }
        return false;
    }


}
