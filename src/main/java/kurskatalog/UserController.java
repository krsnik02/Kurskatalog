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
        return "list-students.xhtml";
    }

    public String persistProfessor()
    {
	accountEJB.persistAccount( professor );
	professor = new Professor();
        return "list-professors.xhtml";
    }

    public String persistAdministrator() 
    {
	accountEJB.persistAccount( administrator );
	administrator = new Administrator();
        return "list-administrators.xhtml";
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
        return "list-students.xhtml";
    }

    public String updateProfessor()
    {
        accountEJB.updateAccount( professor );
        professor = new Professor();
        return "list-professors.xhtml";
    }

    public String updateAdministrator()
    {
        accountEJB.updateAccount( administrator );
        administrator = new Administrator();
        return "list-administrators.xhtml";
    }



    public String deleteStudent( Student stud )
    {
        accountEJB.deleteAccount( stud );
        return "list-students.xhtml";
    }

    public String deleteProfessor( Professor prof )
    {
        accountEJB.deleteAccount( prof );
        return "list-professors.xhtml";
    }

    public String deleteAdministrator( Administrator admin )
    {
        accountEJB.deleteAccount( admin );
        return "list-administrators.xhtml";
    }
};
