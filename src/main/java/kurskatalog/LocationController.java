/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kurskatalog;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author Ben Yuly
 */

@ManagedBean
public class LocationController {
    
    private Location location = new Location();
    
    private List<Location> locations = new ArrayList<Location>();
    
    @EJB
    private LocationEJB locationEJB;
    
    @PostConstruct
    public void initialize()
    {
	locations = locationEJB.getAllLocations();
    }
    
    public String updateLocation()
    {
	locations = null;
	locationEJB.merge( location );
	locations = locationEJB.getAllLocations();
	return "list-locations.xhtml";
    }

    public String createLocation()
    {
        locationEJB.persist( location );
	locations = locationEJB.getAllLocations();
	return "list-locations.xhtml";
    }

    public String modifyLocation( Location loc )
    {
	location = loc;
        return "modify-location.xhtml";
    }

    public String deleteStudent( Location loc )
    {
	locations = null;
	locationEJB.remove( loc );
	locations = locationEJB.getAllLocations();
        return "list-locations.xhtml";
    }

    public void setLocation( Location loc ) { location = loc; }
    public Location getLocation() { return location; }

    public void setStudentsList( List<Location> locs ) { locations = locs; }
    public List<Location> getStudentsList() { return locations; }
    
    
}
