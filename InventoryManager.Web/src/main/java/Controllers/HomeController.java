package Controllers;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import PericosCorp.InventoryManager.Domain.Repositories.Interfaces.IEmployeeRepository;
import PericosCorp.InventoryManager.Domain.Repositories.Interfaces.IRoleRepository;
import ViewModel.AddEmployeeViewModel;

public class HomeController implements Controller {
	private IRoleRepository roleRepository;
	private IEmployeeRepository employeeRepository;
	
	public ModelAndView handleRequest(HttpServletRequest arg0,
			HttpServletResponse arg1) throws Exception {
			String now = (new Date()).toString();
			AddEmployeeViewModel viewModel = new AddEmployeeViewModel();			
			viewModel.setRoles(roleRepository.GetAll());			
		return new ModelAndView("newEmployee","model",viewModel); 
	}
	
	public void setRoleRepository(IRoleRepository _roleRepository) {
		this.roleRepository=_roleRepository;
	}
	
	public void setEmployeeRepository(IEmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}
	

	
}
