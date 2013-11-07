package kurskatalog;

import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Account
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;

	private String username;
	private String password;
	private boolean admin;

	/* Constructors */

	public Account() {}

	/* Getters/Setters */

	public long getId() { return id; }
	public void setId( long id_ ) { id = id_; }

	public String getUsername() { return username; }
	public void setUsername( String username_ ) { username = username_; }

	public String getHashedPassword() { return password; }
	public void setHashedPassword( String password_ ) { password = password_; }

	public boolean isAdmin() { return admin; }
	public void setAdmin( boolean admin_ ) { admin = admin_; }

	public String getPlaintextPassword() { return null; }
	public void setPlaintextPassword( String plaintext_ ) { password = plaintext_; /*FIX THIS*/ }
}
