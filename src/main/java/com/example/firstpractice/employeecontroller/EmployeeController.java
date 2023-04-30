package com.example.firstpractice.employeecontroller;

import com.example.firstpractice.employeedomein.Department;
import com.example.firstpractice.employeedomein.Employee;
import com.example.firstpractice.employeeservice.DepartmentService;
import com.example.firstpractice.employeeservice.EmployeeService;
import com.example.firstpractice.employeedomein.Job;
import com.example.firstpractice.employeeservice.JobService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class EmployeeController {

	private final EmployeeService employeeService;

	private final DepartmentService departmentService;

	private final JobService jobService;

	//Get All employees
	@GetMapping("/employees")
	public String findAll(Model model){
		List<Employee> employeeList = employeeService.findAll();
		model.addAttribute("employeeList", employeeList);
		return "employee/listEmployee";
	}

	//Add employee
	@GetMapping("/addEmployee")
	public String add(Model model){
		List<Job> jobList = jobService.findAll();
		model.addAttribute("jobList", jobList);

		List<Department> departmentList = departmentService.findAll();
		model.addAttribute("departmentList", departmentList);

		return "employee/addEmployee";
	}

	//Add employee
	@PostMapping("/addEmployee")
	public String addPost(@ModelAttribute Employee employee){
		employeeService.save(employee);
		return "redirect:/employees";
	}

	//Edit employee
	@GetMapping("/updateEmployee/{id}")
	public String findById(Model model, @PathVariable Long id){

		Employee employee = employeeService.findById(id);
		model.addAttribute("edit", employee);

		List<Job> jobList = jobService.findAll();
		model.addAttribute("jobList", jobList);

		List<Department> departmentList = departmentService.findAll();
		model.addAttribute("departmentList", departmentList);

		return "employee/updateEmployee";
	}

	//Edit employee
	@PostMapping("/updateEmployee/{id}")
	public String update(@PathVariable Long id,
						 @RequestParam String firstName,
						 @RequestParam String lastName,
						 @RequestParam String email,
						 @RequestParam String phoneNumber,
						 @RequestParam Job job,
						 @RequestParam Department department,
						 @RequestParam LocalDate registerDate){

		Employee employee = employeeService.findById(id);
		employee.setFirstName(firstName);
		employee.setLastName(lastName);
		employee.setEmail(email);
		employee.setPhoneNumber(phoneNumber);
		employee.setJob(job);
		employee.setDepartment(department);
		employee.setRegisterDate(registerDate);

		employeeService.save(employee);
		return "redirect:/employees";
	}

	// Delete employee
	@GetMapping("/deleteEmployee/{id}")
	public String delete(@PathVariable Long id){

		Employee employee = employeeService.findById(id);
		employeeService.delete(employee);
		return "redirect:/employees";
	}

	// Info employee
	@GetMapping("/infoEmployee/{id}")
	public String info(Model model, @PathVariable Long id){

		Employee info = employeeService.findById(id);
		model.addAttribute("info", info);
		return "employee/infoEmployee";
	}
}
