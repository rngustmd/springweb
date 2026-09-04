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
        MovieEntity movieEntity = movieDto.toEntity( );
        MovieEntity savedEntity = movieRepository.save( movieEntity );
        if (savedEntity.getMovieid() >= 1 ) { return true;
        } return false;
    }

    // [2] 영화 목록 전체조회 moviePrint()
        public List<MovieDto> moviePrint(){
        List<MovieEntity> entities = movieRepository.findAll();
        List<MovieDto> list = new ArrayList<>();
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

    // [4] 영화 수정 movieUpdate()
    @Transactional
    public boolean movieUpdate( MovieDto movieDto ){
        Optional<MovieEntity> optional
        = movieRepository.findById(movieDto.getMovieid() );
        if( optional.isPresent() ){
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
