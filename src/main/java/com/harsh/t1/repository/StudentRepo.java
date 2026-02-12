package com.harsh.t1.repository;

import com.harsh.t1.dto.StudentDto;
import com.harsh.t1.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepo extends JpaRepository<Student,Integer> {
    boolean existsByEmail(String email);

}
