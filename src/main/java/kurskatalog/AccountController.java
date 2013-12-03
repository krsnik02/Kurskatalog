package kurskatalog;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class AccountController
{
    private Credentials credentials = new Credentials();
    private Account account = null;

    @EJB
    private AccountEJB accountEJB;
    
    public String login()
    {
	account = accountEJB.login( credentials );
        if ( account != null )
	{
		credentials = null;	
	}
	return "index.xhtml";
    }

    public String logout()
    {
        account = null;
	credentials = new Credentials();
        return "index.xhtml";
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
}
