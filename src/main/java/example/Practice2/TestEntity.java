package example.Practice2;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table( name = "test" ) 
@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class TestEntity {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Integer eno;
    private String econtent;
    private String ewriter;

}
