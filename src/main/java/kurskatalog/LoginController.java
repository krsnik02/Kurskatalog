package kurskatalog;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class LoginController
{
    private Credentials credentials = new Credentials();
    private Account account = null;

    @EJB
    private PersistenceEJB ejb;
    
    public String login()
    {
	account = ejb.getAccountForCredentials( credentials );
        if ( account != null )
	{
	    credentials = new Credentials();
            credentials.setUsername( account.getCredentials().getUsername() );	
	}
	return "index.xhtml";
    }

    public String logout()
    {
        account = null;
	credentials = new Credentials();
        return "index.xhtml";
    }


    public String updateCredentials()
    {
        Account checkAcct = ejb.getAccountForCredentials( credentials );
	if ( checkAcct != null && checkAcct.getId() == account.getId() )
        {
            ejb.update( account );
            credentials = new Credentials();
            credentials.setUsername( account.getCredentials().getUsername() );
        }
        return "account.xhtml";
    }



    public void setAccount( Account acct ) { account = acct; }
    public Account getAccount() { return account; }

    public void setCredentials( Credentials cred ) 
    { 
        if ( account != null )
            account.setCredentials( cred );
        else
            credentials = cred;
    }

    public Credentials getCredentials() 
    {
        if ( account != null )
            return account.getCredentials();
        else
            return credentials;
    }
    
    public boolean isLoggedIn() { return account != null; }
    public boolean isStudent() { return account != null && account instanceof Student; }
    public boolean isProfessor() { return account != null && account instanceof Professor; }
    public boolean isAdministrator() { return account != null && account instanceof Administrator; }
   

    public Professor getAccountAsProfessor() 
    { 
        if ( isProfessor() )
            return (Professor)account;
        else
            return null;
    }

    public Student getAccountAsStudent()
    {
        if ( isStudent() )
            return (Student)account;
        else
            return null;
    }

    public Administrator getAccountAsAdministrator()
    {
        if ( isAdministrator() )
            return (Administrator)account;
        else
            return null;
    }
}
