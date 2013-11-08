/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kurskatalog;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 *
 * @author Ben Yuly
 */

@Entity
public class Course {
    
    @Id
    @GeneratedValue
    private long id;
    
    private String name;
    
    @Column(length = 4096)
    private String description;
    
    @OneToOne
    Department departmentId;
    
    private int code;
    
    private CourseType type;
    
    public Course(){}
    
    public long getID(){ return id; }
    public void setID( long id_ ) { id = id_; }
    
    public String getName() { return name; }
    public void setName( String name_){ name = name_; }
    
    public String getDescription(){ return description; }
    public void setDescription( String description_ ){ description = description_; }
    
    public Department getDepartmentId (){ return departmentId; }
    public void setDepartmentId( Department departmentId_ ){ departmentId = departmentId_; } 
    
    public int getCode(){ return code; }
    public void setCode( int code_ ){ code = code_; }
    
    public CourseType getType(){ return type; }
    public void setType( CourseType type_ ){ type = type_; }
}
