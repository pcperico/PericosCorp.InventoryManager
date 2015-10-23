package Controllers.Admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
	 public String editTeamPage(@PathVariable Integer id,Model model) {
		 System.out.println(id);
		 Role r = roleRepository.Get(id);
		 System.out.println(r.getName());
		 model.addAttribute("role",r);
	     return "/Admin/Roles/AddEdit"; 
	 }
	 
	 
	 
	 
	 @Autowired
	 public void setRoleRepository(IRoleRepository _roleRepository) {
			this.roleRepository=_roleRepository;
	 }

}
