package Controllers.Admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import PericosCorp.InventoryManager.Domain.Entities.Role;
import PericosCorp.InventoryManager.Domain.Repositories.Interfaces.IRoleRepository;

@Controller
public class RolesController {
	private IRoleRepository roleRepository;
	 @RequestMapping(value = "/Admin/roles", method = RequestMethod.GET)
	 public String listRoles(Model model) {        		 
		 model.addAttribute("roles", roleRepository.GetAll());
	     return "/Admin/Roles/index";
	 }
	 
	 @RequestMapping(value = "/Admin/roles/edit/{id}", method = RequestMethod.GET)
	 public String addEditPage(@PathVariable Integer id,Model model) {		 
		 Role r = roleRepository.Get(id);		 
		 model.addAttribute("role",r== null?new Role():r);
	     return "/Admin/Roles/AddEdit"; 
	 }	 
	 
	  @RequestMapping(value= "/Admin/roles/process",method=RequestMethod.POST)	  
	  public String addEditPage(){
		  System.out.println("entroooo");
		  
		  return "redirect:/Admin/roles";
	    } 
	 
	 
	 
	 
	 
	 @Autowired
	 public void setRoleRepository(IRoleRepository _roleRepository) {
			this.roleRepository=_roleRepository;
	 }

}
