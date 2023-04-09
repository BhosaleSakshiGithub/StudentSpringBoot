package com.StudentSpringBoot.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.StudentSpringBoot.Repo.StudentRepo;
import com.StudentSpringBoot.dto.StudentDto;

@Repository
public class StudentDao {

	@Autowired
	StudentRepo stdrepo;
	
	public StudentDto saveStudent(StudentDto student)
	{
		return stdrepo.save(student);
	}
	
	public Optional<StudentDto> getstudentById(int id)
	{
		return stdrepo.findById(id);
	}
	
	public List<StudentDto> getAllstudents()
	{
		return stdrepo.findAll();
	}
	
	public StudentDto updatestudent(StudentDto student)
	{
		return stdrepo.save(student);
	}
	
	public void deletestudent(int id)
	{
		stdrepo.deleteById(id);;
	}
}
