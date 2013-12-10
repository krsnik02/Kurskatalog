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
    
    String semester;
    String section;
    int seats;

    @Temporal(TemporalType.TIME)
    private Date startTime;

    @Temporal(TemporalType.TIME)
    private Date stopTime;

    private List<DayOfWeek> daysOfWeek;

    @OneToOne
    private Location location;

    @OneToOne
    private Professor professor;


    public Offering() 
    {
        course = new Course();
	startTime = new Date();
        stopTime = new Date();
        location = new Location();
        professor = new Professor();
        daysOfWeek = new ArrayList<DayOfWeek>();
    }
    
    public long getId() { return id; }
    public void setId( long id_ ) { id = id_; }
    
    public Course getCourse() { return course; }
    public void setCourse( Course course_ ) { course = course_; };

    public String getSemester() { return semester; }
    public void setSemester( String semester_ ) { semester = semester_; }

    public String getSection() { return section; }
    public void setSection( String section_ ) { section = section_; }
    
    public int getSeats() { return seats; }
    public void setSeats( int seats_ ) { seats = seats_; }
   
    public Date getStartTime() { return startTime; }
    public void setStartTime( Date start ) { startTime = start; }

    public Date getStopTime() { return stopTime; }
    public void setStopTime( Date stop ) { stopTime = stop; }

    public List<DayOfWeek> getDaysOfWeek() { return daysOfWeek; }
    public void setDaysOfWeek( List<DayOfWeek> days ) { daysOfWeek = days; }

    public Location getLocation() { return location; }
    public void setLocation( Location loc ) { location = loc; }

    public Professor getProfessor() { return professor; }
    public void setProfessor( Professor prof ) { professor = prof; }
}
