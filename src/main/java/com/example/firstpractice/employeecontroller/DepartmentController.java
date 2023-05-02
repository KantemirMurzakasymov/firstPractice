package com.example.firstpractice.employeecontroller;

import com.example.firstpractice.employeedomein.Department;
import com.example.firstpractice.employeeservice.DepartmentService;
import com.example.firstpractice.employeedomein.Location;
import com.example.firstpractice.employeeservice.LocationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequiredArgsConstructor
public class DepartmentController {
	
	 private final DepartmentService departmentService;
	 private final LocationService locationService;
	
	//Get All Departments
	@GetMapping("/departments")
	public String findAll(Model model){
		List<Department> departmentList = departmentService.findAll();
		model.addAttribute("departmentList", departmentList);
		return "department/listDepartment";
	}

	//Add Department
	@GetMapping("/addDepartment")
	public String add(Model model){
		List<Location> locationList = locationService.findAll();
		model.addAttribute("locationList", locationList);

		return "department/addDepartment";
	}

	//Add Department
	@PostMapping("/addDepartment")
	public String addPost(@ModelAttribute Department department){
		departmentService.save(department);
		return "redirect:/departments";
	}

	//Edit Department
	@GetMapping("/updateDepartment/{id}")
	public String findById(Model model, @PathVariable Long id){

		Department department = departmentService.findById(id);
		model.addAttribute("edit", department);

		List<Location> locationList = locationService.findAll();
		model.addAttribute("locationList", locationList);

		return "department/updateDepartment";
	}

	//Edit Department
	@PostMapping("/updateDepartment/{id}")
	public String update(@PathVariable Long id,
						 @RequestParam String departmentName,
						 @RequestParam Location location ){

		Department department = departmentService.findById(id);
		department.setDepartmentName(departmentName);
		department.setLocation(location);

		departmentService.save(department);
		return "redirect:/departments";
	}

	// Delete Department
	@GetMapping("/deleteDepartment/{id}")
	public String delete(@PathVariable Long id){

		Department department = departmentService.findById(id);
		departmentService.delete(department);
		return "redirect:/departments";
	}

	// Info Department
	@GetMapping("/infoDepartment/{id}")
	public String info(Model model, @PathVariable Long id){

		Department info = departmentService.findById(id);
		model.addAttribute("info", info);
		return "department/infoDepartment";
	}
}
