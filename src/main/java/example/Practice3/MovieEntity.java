package example.Practice3;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table( name = "movie" )
@NoArgsConstructor @AllArgsConstructor @Builder
@Getter @Setter @ToString
public class MovieEntity extends BaseTime{
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Integer movieid;
    @Column( name = "title" , nullable = true , length = 100 , unique = true )
    private String title;
    @Column( name = "director" , nullable = true , length = 100 , unique = true )
    private String director;
    @Column( columnDefinition = "varchar(100) default '개봉일' not null")
    private String releasedate;
    @Column( insertable = true , updatable = true )
    private double rating;

}
