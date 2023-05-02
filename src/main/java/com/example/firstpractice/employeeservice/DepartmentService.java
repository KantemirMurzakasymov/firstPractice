package com.example.firstpractice.employeeservice;

import com.example.firstpractice.employeedomein.Department;
import com.example.firstpractice.employeerepository.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DepartmentService {

	private final DepartmentRepository departmentRepository;

//	public List<Department> findByName(){
//		return departmentRepository.findByName();
//	}

	//Get All Departments
	public List<Department> findAll(){
		return departmentRepository.findAll();
	}

	//Save Department
	public void save( Department department) {
		departmentRepository.save(department);
	}
	
	//Get Department By Id
	public Department findById(Long id) {
		return departmentRepository.findById(id).get();
	}	
	
	//Delete Department
	public void delete(Department department) {
		departmentRepository.delete(department);
	}

}
