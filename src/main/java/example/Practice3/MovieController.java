package example.Practice3;

import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
@RequiredArgsConstructor
public class MovieController {
    private final MovieService movieService;

    // [1] 영화 등록 movieWrite()
    @PostMapping("/api/movie")
    public boolean movieWrite( @RequestBody MovieDto movieDto ){
        return movieService.movieWrite( movieDto );
    }

    // [2] 영화 목록 전체조회 moviePrint()
    @GetMapping("/api/movie")
    public List<MovieDto> moviePrint( ){
        return movieService.moviePrint();
    }
    
    // [3] 영화 개별조회 movieDetail()
    @GetMapping("/api/movie/{movieid}")
    public MovieEntity movieEntity(@PathVariable( name = "movieid" ) int movieid ){
        return movieService.movieDetail(movieid);
    }
    
    // [4] 영화 수정 movieUpdate()
    @PutMapping("/api/movie")
    public boolean movieUpdate( @RequestBody MovieDto movieDto ){
        return movieService.movieUpdate(movieDto);
    }
    // [5] 영화 삭제 movieDelete()
    @DeleteMapping("/api/movie")
    public boolean movieDelete( @RequestParam( name = "movieid" ) int movieid ){
        return movieService.movieDelete(movieid);
    }
}
