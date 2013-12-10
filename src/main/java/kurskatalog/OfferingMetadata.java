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
    private Offering offeringId;
    
    @OneToOne
    private Location locationId;
    
    @OneToOne
    private Professor professorId;
    
    @OneToOne
    private TimeMeeting time;

    public OfferingMetadata(){}
    
    public long getId() { return id; }
    public void setId( long id_ ) { id = id_; }
    
    public Offering getOfferingId() { return offeringId; }
    public void setOfferingId( Offering offeringId_ ) { offeringId = offeringId_; }
    
    public Location getLocationId() { return locationId; }
    public void setLocationId( Location locationId_ ) { locationId = locationId_; }

    public Professor getProfessorId() { return professorId; }
    public void setProfessorId( Professor professorId_ ) { professorId = professorId_; }
    
    public TimeMeeting getTime() { return time; }
    public void setTime( TimeMeeting time_ ) { time = time_; }
    
}
