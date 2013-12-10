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
    private PersistenceEJB ejb;
    
    Offering offering = new Offering();
    
    public DayOfWeek[] getDaysOfWeek()
    {
        DayOfWeek[] days = { DayOfWeek.MONDAY, DayOfWeek.TUESDAY, DayOfWeek.WEDNESDAY, 
                             DayOfWeek.THURSDAY, DayOfWeek.FRIDAY };
        return days;
    }
 
    public List<Offering> listOfferings() { return ejb.listOfferings(); }

    public Offering getOffering() { return offering; }
    public void setOffering( Offering offering_ ) { offering = offering_; }
    
    public String persistOffering()
    {
	ejb.persist( offering );
	offering = new Offering();
        return "list-offerings.xhtml";
    }

    public String modifyOffering( Offering offer )
    {
        offering = offer;
        return "modify-offering.xhtml";
    }
    
    public String updateOffering()
    {
        ejb.update( offering );
	offering = new Offering();
        return "list-offerings.xhtml";
    }
    
    public String deleteOffering( Offering offer )
    {
        ejb.delete( offer );
        return "list-offerings.xhtml";
    }

    public String register( Student stud, Offering offer )
    {
        stud.getRegisteredCourses().add( offer );
        ejb.update( stud );
        return "list-offerings.xhtml";
    }
}
