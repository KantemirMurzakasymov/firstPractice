package com.example.firstpractice.employeecontroller;

import com.example.firstpractice.employeedomein.Department;
import com.example.firstpractice.employeedomein.Job;
import com.example.firstpractice.employeeservice.DepartmentService;
import com.example.firstpractice.employeeservice.JobService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequiredArgsConstructor
public class JobController {
	private final JobService jobService;
	private final DepartmentService departmentService;

	//Get All jobs
	@GetMapping("/jobs")
	public String findAll(Model model){
		List<Job> jobList = jobService.findAll();
		model.addAttribute("jobList", jobList);
		return "job/listJob";
	}

	//Add job
	@GetMapping("/addJob")
	public String add(Model model){

//		List<Department> departmentList = departmentService.findByName();
//		model.addAttribute("departmentList", departmentList);

		List<Department> departmentList = departmentService.findAll();
		model.addAttribute("departmentList", departmentList);
		return "job/addJob";
	}

	//Add job
	@PostMapping("/addJob")
	public String addPost(@ModelAttribute Job job){
		jobService.save(job);
		return "redirect:/jobs";
	}

	//Edit job
	@GetMapping("/updateJob/{id}")
	public String findById(Model model, @PathVariable Long id){

		Job job = jobService.findById(id);
		model.addAttribute("edit", job);


//		List<Department> departmentList = departmentService.findByName();
//		model.addAttribute("departmentList", departmentList);

		List<Department> departmentList = departmentService.findAll();
		model.addAttribute("departmentList", departmentList);
		return "job/updateJob";
	}

	//Edit job
	@PostMapping("/updateJob/{id}")
	public String update(@PathVariable Long id,
						 @RequestParam String  jobTitle,
						 @RequestParam String minSalary,
						 @RequestParam String maxSalary,
						 @RequestParam Department department){

		Job job = jobService.findById(id);
		job.setJobTitle(jobTitle);
		job.setMinSalary(minSalary);
		job.setMaxSalary(maxSalary);
		job.setDepartment(department);

		jobService.save(job);
		return "redirect:/jobs";
	}

	// Delete job
	@GetMapping("/deleteJob/{id}")
	public String delete(@PathVariable Long id){

		Job job = jobService.findById(id);
		jobService.delete(job);
		return "redirect:/jobs";
	}

	// Info job
	@GetMapping("/infoJob/{id}")
	public String info(Model model, @PathVariable Long id){

		Job info = jobService.findById(id);
		model.addAttribute("info", info);
		return "job/infoJob";
	}
}
