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
    private Course courseId;
    
    String semester;
    String classSection;
    int seats;
    
    public Offering(){}
    
    public long getId() { return id; }
    public void setId( long id_ ) { id = id_; }
    
    public Course getCourseId() { return courseId; }
    public void setCourseId( Course courseId_ ) { courseId = courseId_; };

    public String getSemester() { return semester; }
    public void setSemester( String semester_ ) { semester = semester_; }

    public String getSection() { return classSection; }
    public void setSection( String classSection_ ) { classSection = classSection_; }
    
    public int getSeats() { return seats; }
    public void setSeats( int seats_ ) { seats = seats_; }
    
}