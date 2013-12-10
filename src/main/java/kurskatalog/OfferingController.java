/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kurskatalog;

import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
/**
 *
 * @author Ben Yuly
 */

@ManagedBean
public class OfferingController {
    
    @EJB
    private OfferingEJB offeringEJB;
    
    Offering offering = new Offering();
    
    public OfferingController() { }


    public DayOfWeek[] getDaysOfWeek()
    {
        DayOfWeek[] days = { DayOfWeek.MONDAY, DayOfWeek.TUESDAY, DayOfWeek.WEDNESDAY, 
                             DayOfWeek.THURSDAY, DayOfWeek.FRIDAY };
        return days;
    }
 
    public List<Offering> listOfferings() { return offeringEJB.listOfferings(); }
    public List<Location> listLocations() { return offeringEJB.listLocations(); }

    public Offering getOffering() { return offering; }
    public void setOffering( Offering offering_ ) { offering = offering_; }
    
    public String persistOffering()
    {
	offeringEJB.persistOffering( offering );
	offering = new Offering();
        return "list-OfferingMetadata.xhtml";
    }

    public String modifyOffering( Offering offer )
    {
        offering = offer;
        return "modify-OfferingMetadata.xhtml";
    }
    
    public String updateOffering()
    {
        offeringEJB.updateOffering( offering );
	offering = new Offering();
        return "list-OfferingMetadata.xhtml";
    }
    
    public String deleteOffering( Offering offer )
    {
        offeringEJB.deleteOffering( offer );
        return "list-OfferingMetadata.xhtml";
    }
}
