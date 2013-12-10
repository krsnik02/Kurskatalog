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
    private OfferingEJB offeringEJB;
    
    @PostConstruct
    public void initialize()
    {
        locations = offeringEJB.listLocations();
    }
    
    public String updateLocation()
    {
        locations = null;
        offeringEJB.merge( location );
        locations = offeringEJB.listLocations();
        return "list-locations.xhtml";
    }

    public String createLocation()
    {
        offeringEJB.persist( location );
        locations = offeringEJB.listLocations();
        return "list-locations.xhtml";
    }

    public String modifyLocation( Location loc )
    {
        location = loc;
        return "modify-location.xhtml";
    }

    public String deleteLocation( Location loc )
    {
        locations = null;
        offeringEJB.remove( loc );
        locations = offeringEJB.listLocations();
        return "list-locations.xhtml";
    }

    public void setLocation( Location loc ) { location = loc; }
    public Location getLocation() { return location; }

    public void setLocationsList( List<Location> locs ) { locations = locs; }
    public List<Location> getLocationsList() { return locations; }
    
    
}