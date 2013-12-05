package kurskatalog;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import java.util.List;

@ManagedBean
public class DepartmentController
{
    @EJB
    private DepartmentEJB departmentEJB;

    private Department department = new Department();

    public Department getDepartment() { return department; }
    public void setDepartment( Department dept ) { department = dept; }

    public List<Department> listDepartments() { return departmentEJB.listDepartments(); }

    public String persistDepartment()
    {
        departmentEJB.persistDepartment( department );
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
        departmentEJB.updateDepartment( department );
        department = new Department();
        return "list-departments.xhtml";
    }


    public String deleteDepartment( Department dept )
    {
        departmentEJB.deleteDepartment( dept );
        return "list-departments.xhtml";
    }
}
