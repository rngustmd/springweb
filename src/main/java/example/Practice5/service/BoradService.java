package example.Practice5.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import example.Practice5.model.dto.BoardDto;
import example.Practice5.model.dto.CommentDto;
import example.Practice5.model.entity.BoardEntity;
import example.Practice5.model.repository.BoardRepository;
import example.Practice5.model.repository.CommentRepository;

@Service 
public class BoradService {
    @Autowired private BoardRepository boardRepository;
    @Autowired private CommentRepository commentRepository;

    // [1] 게시글 등록
    public boolean boardWrite( BoardDto boardDto ){
        BoardEntity boardEntity = boardDto.toEntity();
        BoardEntity savedEntity = boardRepository.save(boardEntity);
        if ( savedEntity.getId() >= 1 ) return true;
        return false;
    }

    // [2] 게시글 조회 
    public List<BoardDto> boardRead( ){

        List<BoardEntity> boardEntities = boardRepository.findAll(); 
        List<BoardDto> boardDtos = new ArrayList<>();

        boardEntities.forEach( (boardEntity) -> {   
            BoardDto boardDto = BoardDto.from(boardEntity); 

            boardEntity.getCommentEntities().forEach((commentEntity) -> { 
                CommentDto commentDto = CommentDto.from( commentEntity );
               
                boardDto.getCommentDtos().add(commentDto);
            });
            boardDtos.add(boardDto);
        });
        return boardDtos; 
    }
    
    // [3] 게시글 삭제
    public boolean boardDelete( Integer id , String password ){
        BoardEntity boardEntity = boardRepository.findById(id).orElse(null);
        if( boardEntity != null ){
            if (boardEntity.getPassword().equals(password)) {
                boardRepository.deleteById(id);
            return true;}
        }
        return false;
    }



}

