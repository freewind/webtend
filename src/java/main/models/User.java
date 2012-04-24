package models;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.lang.StringUtils;

import webtend.db.ebean.Model;
import webtend.utils.Crypto;

@Entity
@Table(name = "users")
public class User extends BaseModel {

	@Column(columnDefinition = "TEXT")
	private String email;

	@Column(columnDefinition = "TEXT")
	private String name;

	@Column(columnDefinition = "TEXT")
	private String salt;

	@Column(columnDefinition = "TEXT")
	private String password;

	@Temporal(TemporalType.TIMESTAMP)
	private Date createdAt = new Date();

	@Temporal(TemporalType.TIMESTAMP)
	private Date lastLoginAt;

	public void resetPassword(String password) {
		this.salt = RandomStringUtils.random(16, true, true);
		this.password = Crypto.encryptAES(password, this.salt);
	}

	public boolean validatePassword(String password) {
		String crypted = Crypto.encryptAES(password, this.salt);
		return StringUtils.equals(this.password, crypted);
	}

	public static Finder<String, User> find = new Model.Finder(String.class, User.class);

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getLastLoginAt() {
		return lastLoginAt;
	}

	public void setLastLoginAt(Date lastLoginAt) {
		this.lastLoginAt = lastLoginAt;
	}

}
