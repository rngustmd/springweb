package example.Practice2;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import example.day04.ExamEntity;

@Repository
public interface TestRepository 
extends JpaRepository< TestEntity , Integer >{

}
