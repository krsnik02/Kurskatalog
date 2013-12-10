package kurskatalog;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import java.util.List;

@ManagedBean
public class UserController
{
    @EJB
    private PersistenceEJB ejb;

    private Student student = new Student();
    private Professor professor = new Professor();
    private Administrator administrator = new Administrator();

    public Student getStudent() { return student; }
    public void setStudent( Student stud ) { student = stud; }

    public Professor getProfessor() { return professor; }
    public void setProfessor( Professor prof ) { professor = prof; }

    public Administrator getAdministrator() { return administrator; }
    public void setAdministrator( Administrator admin ) { administrator = admin; }



    public List<Student> listStudents() { return ejb.listStudents(); }
    public List<Professor> listProfessors() { return ejb.listProfessors(); }
    public List<Administrator> listAdministrators() { return ejb.listAdministrators(); }

    public String persistStudent()
    {
	ejb.persist( student );
	student = new Student();
        return "list-students.xhtml";
    }

    public String persistProfessor()
    {
	ejb.persist( professor );
	professor = new Professor();
        return "list-professors.xhtml";
    }

    public String persistAdministrator() 
    {
	ejb.persist( administrator );
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
        ejb.update( student );
        student = new Student();
        return "list-students.xhtml";
    }

    public String updateProfessor()
    {
        ejb.update( professor );
        professor = new Professor();
        return "list-professors.xhtml";
    }

    public String updateAdministrator()
    {
        ejb.update( administrator );
        administrator = new Administrator();
        return "list-administrators.xhtml";
    }



    public String deleteStudent( Student stud )
    {
        ejb.delete( stud );
        return "list-students.xhtml";
    }

    public String deleteProfessor( Professor prof )
    {
        ejb.delete( prof );
        return "list-professors.xhtml";
    }

    public String deleteAdministrator( Administrator admin )
    {
        ejb.delete( admin );
        return "list-administrators.xhtml";
    }
}
