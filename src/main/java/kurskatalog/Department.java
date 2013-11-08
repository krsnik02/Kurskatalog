/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kurskatalog;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 *
 * @author Ben Yuly
 */

@Entity
public class Department {
    
    @Id
    @GeneratedValue
    private long id;
    
    private String name;
    private String code;
    
    @OneToOne
    private Professor headId;
    
    public Department(){}
    
        
    public long getID(){ return id; }
    public void setID( long id_ ) { id = id_; }
    
    public String getName() { return name; }
    public void setName( String name_){ name = name_; }
    
    public String getCode() { return code; }
    public void setCode( String code_){ code = code_; }
    
    public Professor getHeadId(){ return headId; }
    public void setHeadId( Professor headId_ ){ headId = headId_; }
}
