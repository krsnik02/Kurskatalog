package kurskatalog;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author Ben Yuly
 */

@ManagedBean
public class LocationController {
    
    private Location location = new Location();
   
    public List<Location> listLocations() { return ejb.listLocations(); }
     
    
    @EJB
    private PersistenceEJB ejb;
    
    public String updateLocation()
    {
        ejb.update( location );
        return "list-locations.xhtml";
    }

    public String createLocation()
    {
        ejb.persist( location );
        return "list-locations.xhtml";
    }

    public String modifyLocation( Location loc )
    {
        location = loc;
        return "modify-location.xhtml";
    }

    public String deleteLocation( Location loc )
    {
        ejb.delete( loc );
        return "list-locations.xhtml";
    }

    public void setLocation( Location loc ) { location = loc; }
    public Location getLocation() { return location; }

}
