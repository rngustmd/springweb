package example.Practice4.model.entity;

import java.util.ArrayList;
import java.util.List;

import example.Practice4.BaseTime;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table( name = "student")
@NoArgsConstructor @AllArgsConstructor @Builder 
@Getter @Setter @ToString 
public class StudentEntity extends BaseTime{
    @Id 
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Integer studentId;
    @Column
    private String studentName;

    @OneToMany(mappedBy = "studentEntity" , cascade = CascadeType.ALL , fetch = FetchType.LAZY)
    @ToString.Exclude
    @Builder.Default
    private List<EnrollEntity> studentEntities = new ArrayList<>();
}
