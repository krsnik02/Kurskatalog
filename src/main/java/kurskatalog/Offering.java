/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kurskatalog;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 *
 * @author Ben Yuly
 */

@Entity
public class Offering {
    
    @Id
    @GeneratedValue
    private long id;
    
    @OneToOne
    private Course course;
    
    String semester;
    String classSection;
    int seats;

    public Offering() 
    {
        course = new Course();
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
    
}
