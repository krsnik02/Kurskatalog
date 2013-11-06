package kurskatalog;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class AccountController{
    
    private String username;
    private String plaintext;
    
    private boolean admin;
	    
    
    
    public String register(){
	return null;
    }
    
    public String login (){
	return null;
    }
    
    public String getUsername(){
	return username;
    }
    
    public String getPlaintext(){
	return plaintext;
    }
    
    public boolean isAdmin(){
	return admin;
    }
    
    public void setUsername(String newUsername){
	username = newUsername;
    }
    
    public void setPlaintext(String newPlaintext){
	plaintext = newPlaintext;
    }
    
    public void setAdmin(boolean isAdmin){
	admin = isAdmin;
    }
    
    
}