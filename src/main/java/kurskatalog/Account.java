package kurskatalog;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Transient;
import javax.security.auth.kerberos.KerberosPrincipal;
import javax.security.auth.kerberos.KerberosKey;

@Entity
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public abstract class Account
{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;

    private String firstName;
    private String lastName;

    @Column(unique=true)
    private String username;

    private String password;


    /* Constructors */
    public Account() 
    {
	firstName = "";
	lastName = "";
        username = "";
        password = "";
    }

    /* Getters/Setters */

    public long getId() { return id; }
    public void setId( long id_ ) { id = id_; }

    public String getFirstName() { return firstName; }
    public void setFirstName( String first ) { firstName = first; }

    public String getLastName() { return lastName; }
    public void setLastName( String last ) { lastName = last; }

    public String getUsername() { return username; }
    public void setUsername( String username_ ) 
    { 
        username = username_; 
    }

    public String getHashedPassword() { return password; }
    public void setHashedPassword( String password_ ) 
    { 
        password = password_; 
    }

    public String getPlaintextPassword() { return null; }
    public void setPlaintextPassword( String plaintext ) 
    {
	KerberosPrincipal principal = new KerberosPrincipal( username, KerberosPrincipal.KRB_NT_PRINCIPAL );
        KerberosKey key = new KerberosKey( principal, plaintext.toCharArray(), "DES" );
        password = new String( key.getEncoded() );
    }
}
