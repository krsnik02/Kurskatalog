package kurskatalog;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class AccountController
{
    private Account account = new Account();
    private boolean loggedIn = false;

    @EJB
    private AccountEJB accountEJB;
    
    public String register()
    {
	account = accountEJB.register( account );
	loggedIn = true;
	return "index.xhtml";
    }
    
    public String login()
    {
	account = accountEJB.login( account );	
	if ( account == null )
	{
	    account = new Account();
	    loggedIn = false;
	}
	else
	{
	    loggedIn = true;
	}

	return "index.xhtml";
    }


    public String logout()
    {
        account = new Account();
        loggedIn = false;
        return "index.xhtml";
    }

      
    public void setAccount( Account acct ) { account = acct; }
    public Account getAccount() { return account; }
    
    public void setLoggedIn( boolean value ) { loggedIn = value; }
    public boolean isLoggedIn() { return loggedIn; }
}
