package com.harsh.t1.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

@Getter
@Data
public class StudentDto {
    private int id;
    private String name;
    private String email;

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public StudentDto(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

}
