/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kurskatalog;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 * @author Ben Yuly
 */

@Entity
public class Location {
    
    @Id
    @GeneratedValue
    private long id;
    
    private String building;
    
    private int room;
    
    public Location(){}
    
    public long getId() { return id; }
    public void setId( long id_ ) { id = id_; }

    public String getBuilding() { return building; }
    public void setBuilding( String building_ ) { building = building_; }
    
    public int getRoom() { return room; }
    public void setRoom( int room_ ) { room = room_; }
    
}
