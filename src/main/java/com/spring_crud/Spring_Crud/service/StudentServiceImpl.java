package com.spring_crud.Spring_Crud.service;

import com.spring_crud.Spring_Crud.entity.StudentEntity;
import com.spring_crud.Spring_Crud.errors.ErrorExceptionHandler;
import com.spring_crud.Spring_Crud.errors.ErrorNotFoundException;
import com.spring_crud.Spring_Crud.repository.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements  StudentService {

    @Autowired
    ServiceRepository repository;
    @Override
    public List<StudentEntity> getAllStudents() {
        return repository.findAll();
    }

    @Override
    public StudentEntity createStudent(StudentEntity studentEntity) {
        return repository.save(studentEntity);
    }

    @Override
    public Optional<StudentEntity> findByStudentId(int studentId) throws ErrorNotFoundException {
       Optional<StudentEntity> student  =  repository.findById(studentId);
      if(student.isPresent()){
          return  student;

      }else {
           throw new ErrorNotFoundException("Student Id not found");
      }
    }

    @Override
    public String deleteStudent(int studentId) throws ErrorNotFoundException {
        Optional<StudentEntity> student = repository.findById(studentId);
        if(student.isPresent()){

             repository.deleteById(studentId);
             return  "Student Deleted";
        }else{
            throw  new ErrorNotFoundException("Student ID not found from delete");
        }

    }

    @Override
    public StudentEntity updateStudent( int studentId, StudentEntity studentEntity) throws ErrorNotFoundException {
        Optional<StudentEntity> student = repository.findById(studentId);
        if(student.isPresent()){
            StudentEntity  getStudent = student.get();
            getStudent.setStudentName(studentEntity.getStudentName());
            getStudent.setStudentAddress(studentEntity.getStudentAddress());
            getStudent.setStudentPhoneNumber(studentEntity.getStudentPhoneNumber());

        return  repository.save(getStudent);
        }
        throw  new  ErrorNotFoundException("This Student not found");
    }
}
