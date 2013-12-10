package kurskatalog;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import java.util.List;

@ManagedBean
public class DepartmentController
{
    @EJB
    private PersistenceEJB ejb;

    private Department department = new Department();

    public Department getDepartment() { return department; }
    public void Department( Department dept ) { department = dept; }

    
    public List<Department> listDepartments() { return ejb.listDepartments(); }
   


    public String persistDepartment()
    {
        ejb.persist( department );
	department = new Department();
        return "list-departments.xhtml";
    }

    public String modifyDepartment( Department dept )
    {
        department = dept;
        return "modify-department.xhtml";
    }

    public String updateDepartment()
    {
        ejb.update( department );
	department = new Department();
        return "list-departments.xhtml";
    }

    public String deleteDepartment( Department dept )
    {
        ejb.delete( dept );
	department = new Department();
        return "list-departments.xhtml";
    }
}
