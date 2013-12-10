/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kurskatalog;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author Ben Yuly
 */

@Entity
public class Offering 
{
    @Id
    @GeneratedValue
    private long id;
    
    @OneToOne
    private Course course;
    
    private String semester;
    private String section;
    private long seats;

    @Temporal(TemporalType.TIME)
    private Date startTime;

    @Temporal(TemporalType.TIME)
    private Date stopTime;

    private List<DayOfWeek> daysOfWeek;

    private String building;
    private long room;

    @ManyToOne
    private Professor professor;
    
    @OneToMany
    List<Student> registeredStudents;


    public Offering() 
    {
        course = new Course();
	startTime = new Date();
        stopTime = new Date();
        professor = new Professor();
        daysOfWeek = new ArrayList<DayOfWeek>();
    }
    
    public long getId() { return id; }
    public void setId( long id_ ) { id = id_; }
    
    public List<Student> listRegisteredStudents()
    {
	return registeredStudents;
    }
    
    public void setRegisteredStudents( List<Student> registeredStudents_ )
    {
	registeredStudents = registeredStudents_;
    }
    
    public Course getCourse() { return course; }
    public void setCourse( Course course_ ) { course = course_; };

    public String getSemester() { return semester; }
    public void setSemester( String semester_ ) { semester = semester_; }

    public String getSection() { return section; }
    public void setSection( String section_ ) { section = section_; }
    
    public long getSeats() { return seats; }
    public void setSeats( long seats_ ) { seats = seats_; }
   
    public Date getStartTime() { return startTime; }
    public void setStartTime( Date start ) { startTime = start; }

    public Date getStopTime() { return stopTime; }
    public void setStopTime( Date stop ) { stopTime = stop; }

    public List<DayOfWeek> getDaysOfWeek() { return daysOfWeek; }
    public void setDaysOfWeek( List<DayOfWeek> days ) { daysOfWeek = days; }

    public String getBuilding() { return building; }
    public void setBuilding( String bldg ) { building = bldg; }

    public long getRoom() { return room; }
    public void setRoom( long room_ ) { room = room_; }

    public Professor getProfessor() { return professor; }
    public void setProfessor( Professor prof ) { professor = prof; }
}
