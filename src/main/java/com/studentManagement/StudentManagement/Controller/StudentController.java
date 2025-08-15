package com.studentManagement.StudentManagement.Controller;

import com.studentManagement.StudentManagement.Dto.AddNewStudentDto;
import com.studentManagement.StudentManagement.Dto.StudentDto;
import com.studentManagement.StudentManagement.Service.Impl.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private StudentServiceImpl studentService;

    @GetMapping
    public ResponseEntity<List<StudentDto>> getStudent(){
        return ResponseEntity.status(HttpStatus.OK).body(studentService.getAllStudents());

    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentDto> getStudentById(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(studentService.getStudentById(id));
    }

    @PostMapping("/createStudent")
    public ResponseEntity<StudentDto> saveStudent(@RequestBody AddNewStudentDto addNewStudent){
       return ResponseEntity.status(HttpStatus.CREATED).body(studentService.saveStudent(addNewStudent));
    }
}
