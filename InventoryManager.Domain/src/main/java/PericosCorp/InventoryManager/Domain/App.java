package PericosCorp.InventoryManager.Domain;



import PericosCorp.InventoryManager.Domain.Repositories.Implementations.BranchRepository;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	/*EmployeeRepository rr = new EmployeeRepository();
    	Employee r = rr.Get(2);    	
        System.out.println( "Hello World! "+r.getFirstName() +" "+r.getBranch().getName()+" "+r.getEmployeeRoles().size());*/
    	
    	BranchRepository br = new BranchRepository();
    	br.CreateNewBranch("Branch Test", "addr Test", "phone test");
    	  	
    }
}
