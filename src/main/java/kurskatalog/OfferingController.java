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
    
    @EJB
    private CourseEJB courseEJB;
    
    Offering offering = new Offering();
    OfferingMetadata offeringMetadata = new OfferingMetadata();
    
    public List<Course> getCourses(){
	return courseEJB.listCourses();
    }
    
    public List<Professor> getProfessors(){
	return offeringEJB.listProfessors();
    }
    
    public OfferingController( ){ offeringMetadata.setOffering(offering); }
    

    public Offering getOffering() { return offering; }
    public void setOffering( Offering offering_ ) {
	offering = offering_;
	offeringMetadata.setOffering(offering);
    }
    
    public OfferingMetadata getOfferingMetadata() { return offeringMetadata; }
    public void setOffering( OfferingMetadata offeringMetadata_ ) { offeringMetadata = offeringMetadata_; }
    
    public String persistOfferingMetadata()
    {
	offeringEJB.persistOffering( offeringMetadata );
	offeringMetadata = new OfferingMetadata();
	offering = new Offering();
	offeringMetadata.setOffering(offering);
        return "list-OfferingMetadata.xhtml";
    }

    public String modifyOfferingMetadata( OfferingMetadata offeringM )
    {
        offeringMetadata = offeringM;
        return "modify-OfferingMetadata.xhtml";
    }
    
    public String updateOfferingMetadata()
    {
        offeringEJB.updateOffering( offeringMetadata );
	offeringMetadata = new OfferingMetadata();
	offering = new Offering();
	offeringMetadata.setOffering(offering);
        return "list-OfferingMetadata.xhtml";
    }
    
    public String deleteOfferingMetadata( OfferingMetadata offeringM )
    {
        offeringEJB.deleteOffering( offeringM );
        return "list-OfferingMetadata.xhtml";
    }
}
