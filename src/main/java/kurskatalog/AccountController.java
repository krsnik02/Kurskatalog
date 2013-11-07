package kurskatalog;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class AccountController
{
    private String username;
    private String plaintext;
    private boolean admin;

    private Account account = null;

    @EJB
    private AccountEJB accountEJB;
    
    public String register()
    {
	account = new Account();
	account.setUsername( username );
	account.setHashedPassword( plaintext /*TODO: hash*/ );
	account.setAdmin( admin );
	accountEJB.register( account );
	return "index.xhtml";
    }
    
    public String login ()
    {
	account = new Account();
	account.setUsername( username );
	account.setHashedPassword( plaintext /*TODO: hash*/ );
	account = accountEJB.login( account );		
	return "index.xhtml";
    }
    


    public String getUsername()
    {
	return username;
    }
    
    public String getPlaintextPassword()
    {
	return plaintext;
    }
    
    public boolean isAdmin()
    {
	return admin;
    }
    
    public void setUsername(String newUsername)
    {
	username = newUsername;
    }
    
    public void setPlaintextPassword(String newPlaintext)
    {
	plaintext = newPlaintext;
    }
    
    public void setAdmin(boolean isAdmin)
    {
	admin = isAdmin;
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
