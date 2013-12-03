package kurskatalog;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public abstract class Account
{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;

    private String firstName;
    private String lastName;

    @Embedded
    private Credentials credentials;

    /* Constructors */
    public Account() 
    {
	firstName = "";
	lastName = "";
        credentials = new Credentials();
    }

    /* Getters/Setters */

    public long getId() { return id; }
    public void setId( long id_ ) { id = id_; }

    public String getFirstName() { return firstName; }
    public void setFirstName( String first ) { firstName = first; }

    public String getLastName() { return lastName; }
    public void setLastName( String last ) { lastName = last; }

    public Credentials getCredentials() { return credentials; }
    public void setCredentials( Credentials cred ) { credentials = cred; }
}
