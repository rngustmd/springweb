package example.Practice3;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;


@Service
public class MovieService {
    @Autowired private MovieRepository movieRepository;

    // [1] 영화 등록 movieWrite()
    public boolean movieWrite( MovieDto movieDto ){ 
        MovieEntity movieEntity = movieDto.toEntity( ); // 1. DTO -> ENTITY
        MovieEntity savedEntity = movieRepository.save( movieEntity ); // 2. entity save
        if (savedEntity.getMovieid() >= 1 ) { return true;
        } return false;
    }

    // [2] 영화 목록 전체조회 moviePrint()
        public List<MovieDto> moviePrint(){
        List<MovieEntity> entities = movieRepository.findAll(); // 1. findAll 엔티티 전체조회
        List<MovieDto> list = new ArrayList<>(); // 2. 엔티티 -> dto 변환
        entities.forEach( (entity) -> {
            MovieDto dto = MovieDto.from(entity);
            list.add(dto);
        } ); 
        return list;
    }

    // [3] 영화 개별조회 movieDetail()
    public MovieEntity movieDetail( int movieid ){
        Optional<MovieEntity> optional = movieRepository.findById(movieid); 
        if( optional.isPresent() ){ 
            return optional.get();
        }
        return null;
    }

    // public MovieDto 영화개별조회( int movieid ){
    //     Optional<MovieEntity> optional = movieRepository.findById( movieid );// 1. findById 엔티티 개별조회
    //     if( optional.isPresent() ) { // 2. 조회 결과 존재하면 
    //         MovieEntity entity = optional.get(); // 3. 엔티티 꺼내기 
    //         return MovieDto.from(entity);
    //     }
    //     return null; // 참조(객체) 에서는 null 없다는 뜻 
    // }

    // [4] 영화 수정 movieUpdate()
    @Transactional
    public boolean movieUpdate( MovieDto movieDto ){
        // 1. 수정할 pk 이용하여 엔티티 찾기
        Optional<MovieEntity> optional
        = movieRepository.findById(movieDto.getMovieid() );

        if( optional.isPresent() ){ // 2. 존재하면 엔티티 수정
            MovieEntity entity = optional.get();
            entity.setTitle(movieDto.getTitle());
            entity.setDirector(movieDto.getDirector());
            entity.setReleasedate(movieDto.getReleasedate());
            entity.setRating(movieDto.getRating());
            return true;
        }
        return false;
    }

    // [5] 영화 삭제 movieDelete()
    public boolean movieDelete( int movieid ){
        Optional<MovieEntity> optional =
        movieRepository.findById(movieid);
        if(optional.isPresent() ){
            movieRepository.delete(optional.get());
            return true;
        }
        return false;
    }


} // class end
