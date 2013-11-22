package kurskatalog;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import java.util.ArrayList;
import java.util.List;

@ManagedBean
public class ProfessorController
{
    private Professor professor = new Professor();
    private List<Professor> professors = new ArrayList<Professor>();

    @EJB
    private AccountEJB accountEJB;

    @PostConstruct
    public void initialize()
    {
        professors = accountEJB.getAllProfessors();
    }

    public String updateProfessor()
    {
        professors = null;
        accountEJB.mergeAccount( professor );
        professors = accountEJB.getAllProfessors();
        return "list-professors.xhtml";
    }

    public String createProfessor()
    {
        accountEJB.persistAccount( professor );
        professors = accountEJB.getAllProfessors();
        return "list-professors.xhtml";
    }

    public String modifyProfessor( Professor prof )
    {
        professor = prof;
        return "modify-professor.xhtml";
    }

    public String deleteProfessor( Professor prof )
    {
        professors = null;
        accountEJB.removeAccount( prof );
        professors = accountEJB.getAllProfessors();
        return "list-professors.xhtml";
    }

    public void setProfessor( Professor prof ) { professor = prof; }
    public Professor getProfessor() { return professor; }

    public void setProfessorsList( List<Professor> profs ) { professors = profs; }
    public List<Professor> getProfessorsList() { return professors; }
};
