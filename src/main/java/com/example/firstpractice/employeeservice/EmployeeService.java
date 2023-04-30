package com.example.firstpractice.employeeservice;

import com.example.firstpractice.employeedomein.Employee;
import com.example.firstpractice.employeerepository.EmployeeRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class EmployeeService {

	private final EmployeeRepository employeeRepository;
	
	//Get All employees
	public List<Employee> findAll(){
		return employeeRepository.findAll();
	}

	//Save employee
	public void save(Employee employee){
		employeeRepository.save(employee);
	}


	//Get employee By Id
	public Employee findById(Long id){
		return employeeRepository.findById(id).get();
	}	
	
	//Delete employee
	public void delete(Employee employee) {
		employeeRepository.delete(employee);
	}
}
