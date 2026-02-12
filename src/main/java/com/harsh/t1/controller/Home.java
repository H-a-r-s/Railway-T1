package com.harsh.t1.controller;

import com.harsh.t1.dto.StudentDto;
import com.harsh.t1.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class Home {

    private final StudentService studentService;

    @GetMapping("/users")
    public List<StudentDto> getStudent() {
        return studentService.getAllStudents();
    }

    @GetMapping("/users/{id}")
    public StudentDto getStudentById(@PathVariable("id")int id){
        return studentService.getById(id);

    }

    @PostMapping
    public String add(@RequestBody StudentDto dto) {
        studentService.add(dto);
        return "Saved";
    }

    @DeleteMapping("/users/d{id}")
    public String deleteStudentById(@PathVariable int id){
        studentService.deleteById(id);
        return "Deleted";
    }

}
