/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kurskatalog;

import java.util.GregorianCalendar;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Ben Yuly
 */

@Entity
public class TimeMeeting {
        
    @Id
    @GeneratedValue
    private long id;
    
    @Temporal(TemporalType.TIME)
    private GregorianCalendar startTime;
    @Temporal(TemporalType.TIME)
    private GregorianCalendar endTime;
    
    private Day daysMeeting;
    
    public enum Day {
    SUNDAY, MONDAY, TUESDAY, WEDNESDAY,
    THURSDAY, FRIDAY, SATURDAY 
}
    
    public long getId() { return id; }
    public void setId( long id_ ) { id = id_; }
    
    public GregorianCalendar getStartTime() { return startTime; }
    public void setStartTime( GregorianCalendar startTime_ ) { startTime = startTime_; }
    
    public GregorianCalendar getEndTime() { return endTime; }
    public void setEndTime( GregorianCalendar endTime_ ) { endTime = endTime_; }
    
    public Day getDaysMeeting() { return daysMeeting; }
    public void setDaysMeeting( Day daysMeeting_ ) { daysMeeting = daysMeeting_; }
    
}
