package com.example.firstpractice.employeeservice;

import com.example.firstpractice.employeedomein.Location;
import com.example.firstpractice.employeerepository.LocationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class LocationService {

	private final LocationRepository locationRepository;
	
	//Get All location
	public List<Location> findAll(){
		return locationRepository.findAll();
	}

	//Save location
	public void save(Location location) {
		locationRepository.save(location);
	}
	
	//Get location By Id
	public Location findById(Long id) {
		return locationRepository.findById(id).get();
	}	
	
	//Delete location
	public void delete(Location location) {
		locationRepository.delete(location);
	}
}
