/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kurskatalog;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author Ben Yuly
 */

@Entity
public class Prerequisite {
    
    @Id
    @GeneratedValue
    private long id;
    
    @OneToOne
    private Course courseId;
    
    @OneToMany
    private List<Course> prerequisiteCourseIds;
    
    private boolean isCorequisite;
    
    
    public Prerequisite(){}
    
    public long getID(){ return id; }
    
    public void setID( long id_ ) { id = id_; }
    
    public Course getCourseId(){ return courseId; }
    
    public void setCourseId( Course courseId_ ){  courseId = courseId_; }
    
    public List<Course> getPrerequisiteCourseIds(){ return prerequisiteCourseIds; }
    
    public void setPrerequisiteCourseIds( List<Course> prerequisiteCourseIds_ ) { prerequisiteCourseIds = prerequisiteCourseIds_; }
    
    public boolean getIsCoRequisite(){ return isCorequisite; }
    
    public void setIsCoRequisite( boolean isCorequisite_ ) { isCorequisite = isCorequisite_; }
}
