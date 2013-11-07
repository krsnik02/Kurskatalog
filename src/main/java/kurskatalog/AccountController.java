package kurskatalog;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class AccountController
{
    private Account account = new Account();
    private boolean logged_in = false;

    @EJB
    private AccountEJB accountEJB;
    
    public String register()
    {
	accountEJB.register( account );
	return "index.xhtml";
    }
    
    public String login ()
    {
	account = accountEJB.login( account );	
	if ( account == null )
	{
		account = new Account();
		logged_in = false;
	}
	else
	{
		logged_in = true;
	}

	return "index.xhtml";
    }
      
    public void setAccount( Account acct )
    {
        account = acct;
    }

    public Account getAccount()
    {
        return account;
    }
    
    
}
