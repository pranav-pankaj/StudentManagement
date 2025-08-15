package com.studentManagement.StudentManagement.Service;
import com.studentManagement.StudentManagement.Dto.AddNewStudentDto;
import com.studentManagement.StudentManagement.Dto.StudentDto;

import java.util.List;

public interface StudentService {
    List<StudentDto> getAllStudents();

    StudentDto getStudentById(Long id);

    StudentDto saveStudent(AddNewStudentDto addNewStudent);
}
