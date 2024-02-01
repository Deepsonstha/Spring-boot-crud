package com.spring_crud.Spring_Crud.repository;

import com.spring_crud.Spring_Crud.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceRepository extends JpaRepository<StudentEntity, Integer> {
}
