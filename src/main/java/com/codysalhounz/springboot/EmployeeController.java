package com.codysalhounz.springboot;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EmployeeController {

	private final EmployeeRepository employeeRepository;

	public EmployeeController(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}

	@GetMapping({"/", "/employees"})
	public String showEmployees(Model model) {
		model.addAttribute("employees", employeeRepository.findAll());
		model.addAttribute("employee", new Employee());
		return "employees";
	}

	@PostMapping("/employees")
	public String addEmployee(@ModelAttribute Employee employee) {
		employeeRepository.save(employee);
		return "redirect:/employees";
	}

	@PostMapping("/employees/{id}/delete")
	public String deleteEmployee(@PathVariable Long id) {
		employeeRepository.deleteById(id);
		return "redirect:/employees";
	}
}
