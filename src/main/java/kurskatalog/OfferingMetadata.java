/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kurskatalog;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author Ben Yuly
 */
@Entity
public class OfferingMetadata {
    
    @Id
    @GeneratedValue
    private long id;
    
    @OneToOne
    private Offering offering;
    
    @OneToOne
    private Location location;
    
    @OneToOne
    private Professor professor;
    
    @OneToOne
    private TimeMeeting time;

    public OfferingMetadata(){}
    
    public long getId() { return id; }
    public void setId( long id_ ) { id = id_; }
    
    public Offering getOffering() { return offering; }
    public void setOffering( Offering offering_ ) { offering = offering_; }
    
    public Location getLocation() { return location; }
    public void setLocation( Location locationId_ ) { location = locationId_; }

    public Professor getProfessor() { return professor; }
    public void setProfessor( Professor professorId_ ) { professor = professorId_; }
    
    public TimeMeeting getTime() { return time; }
    public void setTime( TimeMeeting time_ ) { time = time_; }
    
}
