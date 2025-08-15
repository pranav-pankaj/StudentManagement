package com.studentManagement.StudentManagement.Service.Impl;

import com.studentManagement.StudentManagement.Config.ModelMapperConfig;
import com.studentManagement.StudentManagement.Dto.AddNewStudentDto;
import com.studentManagement.StudentManagement.Dto.StudentDto;
import com.studentManagement.StudentManagement.Models.Student;
import com.studentManagement.StudentManagement.Repository.StudentRepository;
import com.studentManagement.StudentManagement.Service.StudentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public List<StudentDto> getAllStudents() {
        List<Student> findAllStudent = studentRepository.findAll();
       return findAllStudent.stream().map(student ->
               modelMapper.map(student,StudentDto.class)).toList();
    }

    @Override
    public StudentDto getStudentById(Long id) {
        Optional<Student> findByID = studentRepository.findById(id);
       return modelMapper.map(findByID,StudentDto.class);
    }

    @Override
    public StudentDto saveStudent(AddNewStudentDto addNewStudent) {
        Student newStudent=modelMapper.map(addNewStudent,Student.class);
        Student save = studentRepository.save(newStudent);
        StudentDto map = modelMapper.map(save, StudentDto.class);
        return map;
    }
}
