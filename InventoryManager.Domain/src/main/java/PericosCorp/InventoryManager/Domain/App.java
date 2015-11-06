package PericosCorp.InventoryManager.Domain;



import PericosCorp.InventoryManager.Domain.Entities.Role;
import PericosCorp.InventoryManager.Domain.Repositories.Implementations.RoleRepository;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	RoleRepository rr = new RoleRepository();
    	Role r = rr.Get(1);    	
        System.out.println( "Hello World! "+r.getName() +" "+ (r.isStatus()?"Active":"Inactive"));
    	  	
    }
}
