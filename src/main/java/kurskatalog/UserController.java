package kurskatalog;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import java.util.List;

@ManagedBean
public class UserController
{
    @EJB
    private AccountEJB accountEJB;

    public List<Student> listStudents() { return accountEJB.listStudents(); }
    public List<Professor> listProfessors() { return accountEJB.listProfessors(); }
    public List<Administrator> listAdministrators() { return accountEJB.listAdministrators(); }

    public String delete( Account acct )
    {
        accountEJB.deleteAccount( acct );
        return "list-users.xhtml";
    }
};
