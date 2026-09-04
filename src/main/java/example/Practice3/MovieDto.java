package example.Practice3;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor @AllArgsConstructor @Builder
@Getter @Setter @ToString
public class MovieDto {
    private Integer movieid;
    private String title;
    private String director;
    private String releasedate;
    private double rating;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;

    public MovieEntity toEntity( ){
        return MovieEntity.builder()
                .movieid(this.movieid)        
                .title(this.title)
                .director(this.director)
                .releasedate(this.releasedate)
                .rating(this.rating)
                .build();
    }

    public static MovieDto from( MovieEntity movieEntity ){
        return MovieDto.builder()
                .movieid( movieEntity.getMovieid() )
                .title( movieEntity.getTitle() )
                .director( movieEntity.getDirector() )
                .releasedate( movieEntity.getReleasedate() )
                .rating( movieEntity.getRating() )
                .createDate( movieEntity.getCreateDate() )
                .updateDate( movieEntity.getUpdateDate() )
                .build();
    }

} // CLASS END
