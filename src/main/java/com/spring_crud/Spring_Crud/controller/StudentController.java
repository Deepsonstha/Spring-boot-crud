package com.spring_crud.Spring_Crud.controller;

import com.spring_crud.Spring_Crud.entity.StudentEntity;
import com.spring_crud.Spring_Crud.errors.ErrorNotFoundException;
import com.spring_crud.Spring_Crud.response.ResponseHandler;
import com.spring_crud.Spring_Crud.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class StudentController {

    @Autowired
    StudentService service;

    @GetMapping("/student")
    public ResponseEntity<Object> getAllStudents(){
        return ResponseHandler.responseBuilder(
                "Successfully Get all Student",
                HttpStatus.OK,
                service.getAllStudents()
        );
    }

    @PostMapping("/student")
    public ResponseEntity<Object> createStudent(@Valid @RequestBody StudentEntity customer){
        return  ResponseHandler.responseBuilder(
                "Successfully created",
                HttpStatus.OK,
                service.createStudent(customer)


        );
    }

    @GetMapping("/student/{id}")
    public  ResponseEntity<Object> findByStudentId(@PathVariable("id") int studentId) throws ErrorNotFoundException {
        return  ResponseHandler.responseBuilder(
                "Successfully Get Student data",
                HttpStatus.OK,
                service.findByStudentId(studentId)

        );
    }


    @PutMapping("/student/update/{id}")
    public   ResponseEntity<Object> updateStudentId(@Valid @PathVariable("id") int studentId, @RequestBody StudentEntity student) throws ErrorNotFoundException {
        return  ResponseHandler.responseBuilder(
                "Student Update Successfully",
                HttpStatus.OK,
                service.updateStudent(studentId ,student)
        );
    }






}
