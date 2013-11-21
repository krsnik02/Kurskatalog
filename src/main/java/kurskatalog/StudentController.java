package kurskatalog;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import java.util.ArrayList;
import java.util.List;

@ManagedBean
public class StudentController
{
    private Student student = new Student();
    private List<Student> students = new ArrayList<Student>();

    @EJB
    private AccountEJB accountEJB;

    @PostConstruct
    public void initialize()
    {
        students = accountEJB.getAllStudents();
    }

    public String createStudent()
    {
	accountEJB.persistStudent( student );
	students = accountEJB.getAllStudents();
        return "list-students.xhtml";
    }

    public String updateStudent()
    {
	accountEJB.persistStudent( student );
	students = accountEJB.getAllStudents();
        return "list-students.xhtml";
    }

    public String deleteStudent()
    {
	accountEJB.deleteStudent( student );
	students = accountEJB.getAllStudents();
        return "list-students.xhtml";
    }

    public void setStudent( Student stud ) { student = stud; }
    public Student getStudent() { return student; }

    public void setStudentsList( List<Student> studs ) { students = studs; }
    public List<Student> getStudentsList() { return students; }
}
