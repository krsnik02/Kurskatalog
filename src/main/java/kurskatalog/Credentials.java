package kurskatalog;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.security.auth.kerberos.KerberosPrincipal;
import javax.security.auth.kerberos.KerberosKey;

@Embeddable
public class Credentials
{
    @Column(unique=true)
    private String username;

    private String password;

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
