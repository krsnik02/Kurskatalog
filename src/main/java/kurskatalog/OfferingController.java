/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kurskatalog;

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
    OfferingMetadata offeringMetadata = new OfferingMetadata();
    
    
    public OfferingController( ){ offeringMetadata.setOfferingId(offering); }
    

    public Offering getOffering() { return offering; }
    public void setOffering( Offering offering_ ) {
	offering = offering_;
	offeringMetadata.setOfferingId(offering);
    }
    
    public OfferingMetadata getOfferingMetadata() { return offeringMetadata; }
    public void setOffering( OfferingMetadata offeringMetadata_ ) { offeringMetadata = offeringMetadata_; }
    
    public String persistOfferingMetadata()
    {
	offeringEJB.persistOffering( offeringMetadata );
	offeringMetadata = new OfferingMetadata();
	offering = new Offering();
	offeringMetadata.setOfferingId(offering);
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
	offeringMetadata.setOfferingId(offering);
        return "list-OfferingMetadata.xhtml";
    }
    
    public String deleteStudent( OfferingMetadata offeringM )
    {
        offeringEJB.deleteOffering( offeringM );
        return "list-OfferingMetadata.xhtml";
    }
}
