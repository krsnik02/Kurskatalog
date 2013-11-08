package kurskatalog;

import javax.persistence.Entity;

@Entity
public class Student extends Account
{
    private String firstName;
    private String lastName;

    /* Constructors */

    public Student() 
    {
        firstName = "";
        lastName = "";
    }

    /* Getters/Setters */

    public String getFirstName() { return firstName; }
    public void setFirstName( String first ) { firstName = first; }

    public String getLastName() { return lastName; }
    public void setLastName( String last ) { lastName = last; }
};
