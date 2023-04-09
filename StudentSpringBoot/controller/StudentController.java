package com.StudentSpringBoot.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.StudentSpringBoot.dao.StudentDao;
import com.StudentSpringBoot.dto.StudentDto;



@RestController
@RequestMapping("/students")
public class StudentController {

	@Autowired
	StudentDao stdDao;
	
	@PostMapping
	public StudentDto saveData(@RequestBody StudentDto student)
	{
		return stdDao.saveStudent(student);
	}
	
	@GetMapping("/{id}")
	public StudentDto getstudentById(@PathVariable int id)
	{
		Optional<StudentDto> op = stdDao.getstudentById(id);
		if(op.isEmpty()) {
			return null;
		}
		else {
			return op.get();
		}
	}
	
	@GetMapping
	public List<StudentDto> getAllOrder() 
	{
		return stdDao.getAllstudents();
	}
	
	@PutMapping
	public StudentDto updateFoodOrder(@RequestBody StudentDto student)
	{
		return stdDao.saveStudent(student);
	}
	
	@DeleteMapping
	public String deleteFoodOrder(@RequestParam int id)
	{
		Optional<StudentDto> op = stdDao.getstudentById(id);
		if(op.isPresent())
		{
			stdDao.deletestudent(id);
			return "Student Info is deleted";
		}
		else {
			return "Data is not found";
		}
	}
}
