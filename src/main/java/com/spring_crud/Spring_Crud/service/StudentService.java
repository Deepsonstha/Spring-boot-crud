package com.spring_crud.Spring_Crud.service;

import com.spring_crud.Spring_Crud.entity.StudentEntity;
import com.spring_crud.Spring_Crud.errors.ErrorNotFoundException;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    public List<StudentEntity> getAllStudents();
    public  StudentEntity createStudent(StudentEntity studentEntity);
    public Optional<StudentEntity> findByStudentId( int studentId) throws ErrorNotFoundException;
    public String deleteStudent( int studentId) throws ErrorNotFoundException;
    public  StudentEntity updateStudent(int studentId, StudentEntity studentEntity) throws ErrorNotFoundException;
}
