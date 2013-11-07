package kurskatalog;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

@ManagedBean
public class AccountController{
    
    private String username;
    private String plaintext;
    private boolean admin;

    @EJB
    private AccountEJB accountEJB;
    
    public String register()
    {
	Account account = new Account();
	account.setUsername( username );
	account.setHashedPassword( plaintext /*TODO: hash*/ );
	account.setAdmin( admin );
	accountEJB.createAccount( account );
	return "index.xhtml";
    }
    
    public String login ()
    {
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
    
    
}
