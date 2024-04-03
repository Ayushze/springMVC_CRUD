package com.company.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.company.pojo.Employee;
import com.company.service.EmployeeServiceInterface;
import com.company.service.EmployeeServiceImplementation;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class EmployeeController {

	private EmployeeServiceInterface employeeService;

	public void setEmployeeService(EmployeeServiceImplementation employeeService) {
		this.employeeService = employeeService;
	}

	@RequestMapping(value = "/insertEmployeeAction", method = RequestMethod.POST)
	public String insertEmployee(@ModelAttribute("employee") Employee employee) {
		System.out.println("Message 28, controller: "+employee);
		employeeService.insertEmployeeService(employee);
		return "redirect:/readAllEmployeeAction";
	}

	@RequestMapping(value = "/readAllEmployeeAction", method = RequestMethod.GET)
	public String readALLEmployee(Model model) {
		List<Employee> list = employeeService.ReadAllEmployeeService();
		model.addAttribute("list", list);
		System.out.println("Read all controller");
		return "ReadAllEmployee";
	}
	
	@RequestMapping(value = "/getEmployeeById/{id}", method = RequestMethod.GET)
    public String getEmployeeById(@PathVariable int id, Model model) {
        Employee employee = employeeService.ReadEmployeeByIdService(id);
        model.addAttribute("employee", employee); // Add employee object to the model
        return "UpdatePage"; // Forward to the update page
    }

	@RequestMapping("/UpdateEmployeeAction/{id}")
	public String showUpdateForm(@PathVariable int id, Employee employee, Model model) {
		employee = employeeService.ReadEmployeeByIdService(id);
		System.out.println("Message 51, controller: "+employee);
		model.addAttribute("employee", employee);
		employeeService.UpdateEmployeeService(employee);
		return "redirect:/readAllEmployeeAction";
	}

	@RequestMapping(value = "/DeleteEmployeeAction/{id}", method = RequestMethod.GET)
	public String deleteEmployeeById(@PathVariable("id") int id) {
		employeeService.DeleteEmployeeService(id);
		return "redirect:/readAllEmployeeAction";
	}
}