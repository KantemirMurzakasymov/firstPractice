package com.example.firstpractice.employeeservice;

import com.example.firstpractice.employeedomein.Job;
import com.example.firstpractice.employeerepository.JobRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class JobService {

	private final JobRepository jobRepository;
	
	//Get All jobs
	public List<Job> findAll(){
		return jobRepository.findAll();
	}


	//Save job
	public void save(Job job){
		jobRepository.save(job);
	}
	
	//Get job By Id
	public Job findById(Long id){
		return jobRepository.findById(id).get();
	}	
	
	//Delete job
	public void delete(Job job){
		jobRepository.delete(job);
	}
}
