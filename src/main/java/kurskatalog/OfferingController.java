/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kurskatalog;

import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import java.util.ArrayList;
import javax.annotation.PostConstruct;

/**
 *
 * @author Ben Yuly
 */

@ManagedBean
public class OfferingController {
    
    @EJB
    private PersistenceEJB ejb;
    
    private Offering offering = new Offering();
    private OfferingSearchQuery searchQuery = new OfferingSearchQuery();
    
    public DayOfWeek[] getDaysOfWeek()
    {
        DayOfWeek[] days = { DayOfWeek.MONDAY, DayOfWeek.TUESDAY, DayOfWeek.WEDNESDAY, 
                             DayOfWeek.THURSDAY, DayOfWeek.FRIDAY };
        return days;
    }
 

    public Offering getOffering() { return offering; }
    public void setOffering( Offering offering_ ) { offering = offering_; }
    
    public OfferingSearchQuery getSearchQuery() { return searchQuery; }
    public void setSearchQuery( OfferingSearchQuery search ) { searchQuery = search; }

    private List<Offering> offeringList;
    
    public List<Offering> getOfferingList() { return offeringList; }
    public void setOfferingList( List<Offering> offerings ) { offeringList = offerings; }

    @PostConstruct
    public void initialize()
    {
        searchQuery = new OfferingSearchQuery();
        offeringList = ejb.listOfferings( searchQuery );
    }

 
    public String search()
    {
        offeringList = ejb.listOfferings( searchQuery );
        return "list-offerings.xhtml";
    }


    public String persistOffering()
    {
	offering.getProfessor().listCourses().remove(offering);
	offering.getProfessor().listCourses().add(offering);

	ejb.persist( offering );
	offering = new Offering();
        offeringList = ejb.listOfferings( searchQuery );
        return "list-offerings.xhtml";
    }

    public String modifyOffering( Offering offer )
    {
	offer.getProfessor().listCourses().remove(offer);
	offer.getProfessor().listCourses().add(offer);
        offering = offer;
        return "modify-offering.xhtml";
    }
    
    public String updateOffering()
    {
	offering.getProfessor().listCourses().remove(offering);
	offering.getProfessor().listCourses().add(offering);

        ejb.update( offering );
	offering = new Offering();
        offeringList = ejb.listOfferings( searchQuery );
        return "list-offerings.xhtml";
    }
    
    public String deleteOffering( Offering offer )
    {
	offer.getProfessor().listCourses().remove(offer);
        ejb.delete( offer );
        offering = new Offering();
        offeringList = ejb.listOfferings( searchQuery );
        return "list-offerings.xhtml";
    }


    public String listRegistered( Offering offer )
    {
        offering = offer;
        return "registered-students.xhtml";
    }


    public String register( Student stud, Offering offer )
    {
        stud.listCourses().add( offer );
	offer.getRegisteredStudents().add( stud );
        ejb.update( stud );
        return "account.xhtml";
    }

    public String deregister( Student stud, Offering offer )
    {
        stud.listCourses().remove( offer );
	offer.getRegisteredStudents().remove( stud );
        ejb.update( stud );
        return "account.xhtml";
    }
}
