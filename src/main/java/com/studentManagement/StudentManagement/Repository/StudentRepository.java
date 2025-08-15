package com.studentManagement.StudentManagement.Repository;

import com.studentManagement.StudentManagement.Models.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Long> {
}
