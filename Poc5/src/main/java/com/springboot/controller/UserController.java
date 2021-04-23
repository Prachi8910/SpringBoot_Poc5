package com.springboot.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.springboot.exception.RecordNotFoundException;
import com.springboot.model.User;
import com.springboot.service.UserService;





@Controller
@RequestMapping("/")
public class UserController 
{
	@Autowired
	private UserService service;

	@GetMapping("/")
	public String getAllUsers(Model model) 
	{
		return findPaginated(1,model);
	
	}

	@RequestMapping(path = {"/edit", "/edit/{id}"})
	public String editUserById(Model model, @PathVariable("id") Optional<Long> id) 
							throws RecordNotFoundException 
	{
		if (id.isPresent()) {
			User entity = service.getUserById(id.get());
			model.addAttribute("User", entity);
		} else {
			model.addAttribute("User", new User());
		}
		return "add-edit-User";
	}
	
	@RequestMapping(path = "/delete/{id}")
	public String deleteUserById(Model model, @PathVariable("id") Long id) 
							throws RecordNotFoundException 
	{
		service.deleteUserById(id);
		return "redirect:/";
	}

	@RequestMapping(path = "/createUser", method = RequestMethod.POST)
	public String createOrUpdateUser(User User) 
	{
		service.createOrUpdateUser(User);
		return "redirect:/";
	}
	
	@GetMapping("/page/{pageNo}")
	public String findPaginated(@PathVariable (value="pageNo")int pageNo,Model model) {
		int pageSize=5;
		Page<User> page=service.findPaginated(pageNo,pageSize);
		List<User> listEmployees=page.getContent();
		model.addAttribute("currentPage",pageNo);
		model.addAttribute("totalPages", page.getTotalPages());
		model.addAttribute("totalItems", page.getTotalElements());
		model.addAttribute("listEmployees", listEmployees);
		return "list-Users";
	}
}