package kurskatalog;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;

@Entity
public class Prerequisite
{
    @Id
    @GeneratedValue
    private long id;

    private Course course;
    private boolean corequisite;

    public Prerequisite()
    {
        course = new Course();
        corequisite = false;
    }

    public long getId() { return id; }
    public void setId( long id_ ) { id = id_; }

    public Course getCourse() { return course; }
    public void setCourse( Course c ) { course = c; }

    public boolean isCorequisite() { return corequisite; }
    public void setCorequisite( boolean coreq ) { corequisite = coreq; }
}
