package com.harsh.t1.service;

import com.harsh.t1.dto.StudentDto;
import com.harsh.t1.entity.Student;

import java.util.List;

public interface StudentService {
    List<StudentDto> getAllStudents();

    StudentDto getById(int id);

    void add(StudentDto dto);

    void deleteById(int id);
}
