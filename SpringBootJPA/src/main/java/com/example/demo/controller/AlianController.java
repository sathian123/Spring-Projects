package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dao.AlianRepo;
import com.example.demo.model.Alian;

@RestController
public class AlianController {

	@Autowired
	AlianRepo alianRepo;

	@RequestMapping("/")
	public String home() {

		return "home.jsp";

	}

	@GetMapping("/addAlian")
	public String addAlian(Alian alian) {

		alianRepo.save(alian);

		return "home.jsp";

	}
	
	
	@PostMapping("/addAlian")
	public Alian addAlians(@RequestBody Alian alian) {

		alianRepo.save(alian);

		return alian;

	}
	
	
	
	@PutMapping("/addAlian")
	public Alian saveorupdateAlians(@RequestBody Alian alian) {

		alianRepo.save(alian);

		return alian;

	}

	@RequestMapping("/getAlian")
	public ModelAndView getAlian(@RequestParam int aid) {

		ModelAndView mv = new ModelAndView("fetch.jsp");
		
		
//		System.out.println(alianRepo.findByTech("java"));
//		System.out.println(alianRepo.findByAidGreaterThan(aid));
//		System.out.println(alianRepo.findByTechSorted("java"));

		Alian a = alianRepo.findById(aid).orElse(new Alian());
		mv.addObject("alian", a);

		return mv;

	}
	
	
	@RequestMapping(path="/alians",produces="application/xml")
	@ResponseBody
	public List<Alian> alians() {

		return alianRepo.findAll();
		
	}
	
	
	@RequestMapping("/alian/{aid}")
	@ResponseBody
	public Optional<Alian> alian(@PathVariable int aid) {

		return alianRepo.findById(aid);


	}
	@DeleteMapping("/deleteAlian/{aid}")
	public String deleteAlians(@PathVariable int aid) {

		alianRepo.deleteById(aid);
		return "deleted";

	}	
	
	@RequestMapping("/deleteAlian")
	public ModelAndView deleteAlian(@RequestParam int aid) {

		ModelAndView mv = new ModelAndView("home.jsp");
		alianRepo.deleteById(aid);
		return mv;

	}
	
	
	@RequestMapping("/updateAlian")
	public ModelAndView updateAlian(@RequestParam int aid,@RequestParam String aname) {
		
		Alian a=alianRepo.findById(aid).orElse(new Alian());
		a.setAname(aname);
		alianRepo.save(a);

		ModelAndView mv = new ModelAndView("home.jsp");
		return mv;

	}

}
