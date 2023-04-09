package com.StudentSpringBoot.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.StudentSpringBoot.dto.StudentDto;

public interface StudentRepo extends JpaRepository<StudentDto, Integer>{

}
