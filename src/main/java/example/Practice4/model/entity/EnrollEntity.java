package example.Practice4.model.entity;

import example.Practice4.BaseTime;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table ( name = "enroll")
@NoArgsConstructor @AllArgsConstructor @Builder 
@Setter @Getter @ToString 
public class EnrollEntity extends BaseTime{
    @Id 
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer enrollId;
    @Column ()
    private String status;
    @JoinColumn (name = "course_id")
    @ManyToOne 
    private CourseEntity courseEntity;
    @JoinColumn(name = "student_id")
    @ManyToOne 
    private StudentEntity studentEntity;
}
