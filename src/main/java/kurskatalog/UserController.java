package kurskatalog;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import java.util.List;

@ManagedBean
public class UserController
{
    @EJB
    private AccountEJB accountEJB;

    Student student = new Student();
    Professor professor = new Professor();
    Administrator administrator = new Administrator();

    public Student getStudent() { return student; }
    public void setStudent( Student stud ) { student = stud; }

    public Professor getProfessor() { return professor; }
    public void setProfessor( Professor prof ) { professor = prof; }

    public Administrator getAdministrator() { return administrator; }
    public void setAdministrator( Administrator admin ) { administrator = admin; }



    public List<Student> listStudents() { return accountEJB.listStudents(); }
    public List<Professor> listProfessors() { return accountEJB.listProfessors(); }
    public List<Administrator> listAdministrators() { return accountEJB.listAdministrators(); }

    public String persistStudent()
    {
	accountEJB.persistAccount( student );
	student = new Student();
        return "list-users.xhtml#tab-students";
    }

    public String persistProfessor()
    {
	accountEJB.persistAccount( professor );
	professor = new Professor();
        return "list-users.xhtml#tab-professors";
    }

    public String persistAdmininstrator() 
    {
	accountEJB.persistAccount( administrator );
	administrator = new Administrator();
        return "list-users.xhtml#tab-administrators";
    }



    public String modifyStudent( Student stud )
    {
        student = stud;
        return "modify-student.xhtml";
    }

    public String modifyProfessor( Professor prof )
    {
        professor = prof;
        return "modify-professor.xhtml";
    }

    public String modifyAdministrator( Administrator admin )
    {
        administrator = admin;
        return "modify-administrator.xhtml";
    }

    public String updateStudent()
    {
        accountEJB.updateAccount( student );
        student = new Student();
        return "list-users.xhtml#tab-students";
    }

    public String updateProfessor()
    {
        accountEJB.updateAccount( professor );
        professor = new Professor();
        return "list-users.xhtml#tab-professors";
    }

    public String updateAdministrator()
    {
        accountEJB.updateAccount( administrator );
        administrator = new Administrator();
        return "list-users.xhtml#tab-administrators";
    }



    public String deleteAccount( Account acct )
    {
        accountEJB.deleteAccount( acct );
        return "list-users.xhtml";
    }
};
