package com.example.firstpractice.employeecontroller;

import com.example.firstpractice.employeedomein.Location;
import com.example.firstpractice.employeeservice.LocationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class LocationController {
	
	private final LocationService locationService;

	//Get All locations
	@GetMapping("/locations")
	public String findAll(Model model){
		List<Location> locationList = locationService.findAll();
		model.addAttribute("locationList", locationList);
		return "location/listLocation";
	}

	//Add location
	@GetMapping("/addLocation")
	public String add(){
		return "location/addLocation";
	}

	//Add location
	@PostMapping("/addLocation")
	public String addPost(@ModelAttribute Location location){
		locationService.save(location);
		return "redirect:/locations";
	}

	//Edit location
	@GetMapping("/updateLocation/{id}")
	public String findById(Model model, @PathVariable Long id){

		Location location = locationService.findById(id);
		model.addAttribute("edit", location);
		return "location/updateLocation";
	}

	//Edit location
	@PostMapping("/updateLocation/{id}")
	public String update(@PathVariable Long id,
						 @RequestParam String streetAddress,
						 @RequestParam String postalCode,
						 @RequestParam String city ){

		Location location = locationService.findById(id);
		location.setStreetAddress(streetAddress);
		location.setPostalCode(postalCode);
		location.setCity(city);

		locationService.save(location);
		return "redirect:/locations";
	}

	// Delete location
	@GetMapping("/deleteLocation/{id}")
	public String delete(@PathVariable Long id){

		Location location = locationService.findById(id);
		locationService.delete(location);
		return "redirect:/locations";
	}

	// Info location
	@GetMapping("/infoLocation/{id}")
	public String info(Model model, @PathVariable Long id){

		Location info = locationService.findById(id);
		model.addAttribute("info", info);
		return "location/infoLocation";
	}
}
