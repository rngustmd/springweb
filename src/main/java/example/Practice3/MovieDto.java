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

    // 1. DTO -> ENTITY : 주로 등록시
    public MovieEntity toEntity( ){ // static 제외한 이유? 해당 메소드 호출하는 대상이 dto인스턴스라서
        return MovieEntity.builder()
                .movieid(this.movieid)        
                .title(this.title)
                .director(this.director)
                .releasedate(this.releasedate)
                .rating(this.rating)
                .build();

    }

    // 2. ENTITY -> DTO : 주로 조회시
    public static MovieDto from( MovieEntity movieEntity ){ // statci 포함한 이유? 해당 메소드 호출하는 대상의 dto 인스턴스가 없는
        
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
