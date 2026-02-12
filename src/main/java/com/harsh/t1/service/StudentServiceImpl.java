package com.harsh.t1.service;

import com.harsh.t1.dto.StudentDto;
import com.harsh.t1.entity.Student;
import com.harsh.t1.repository.StudentRepo;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService{

    private final StudentRepo studentRepo;
    private final ModelMapper modelMapper;
    @Override
    public List<StudentDto> getAllStudents() {
        List<Student> students = studentRepo.findAll();
        return students.stream()
                .map(student -> new StudentDto(student.getId(),student.getName(),student.getEmail()))
                .toList();
    }

    @Override
    public StudentDto getById(int id) {
        Student student = studentRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found with id: " + id));
        return modelMapper.map(student,StudentDto.class);
    }

    @Override
    public void add(StudentDto dto) {
        if(dto.getName() == null || dto.getName().isBlank()){
            throw new RuntimeException("Name can't be empty or blank...");
        }

        if(dto.getEmail().isEmpty() || dto.getEmail().isBlank()){
            throw new RuntimeException("Email can't be empty or blank...");
        }

        if(studentRepo.existsByEmail(dto.getEmail())){
            throw new RuntimeException("Email already exists...");
        }

        Student student = new Student();
        student.setName(dto.getName());
        student.setEmail(dto.getEmail());
        studentRepo.save(student);
    }

    @Override
    public void deleteById(int id) {
        Student student = studentRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("No Student found with id: " + id));
        studentRepo.deleteById(id);
    }

    private StudentDto mapDto(Student student) {
        return new StudentDto(
                student.getId(),
                student.getName(),
                student.getEmail()
        );
    }

}
