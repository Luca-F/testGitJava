package fr.formation.inti.entity;

import static javax.persistence.GenerationType.IDENTITY;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity 
@Table(name = "user", catalog = "bd_formation")
public class User implements java.io.Serializable{
	
	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "iduser", unique = true, nullable = false)
	private Integer userid;
	

	private String roleName;
	
	@Column(name = "email", unique = true, length = 30)
	private String email;

	private String password;

	private String firstName;

	private String lastName;

	private Date dateCreation;
	
	public User() {
		
	}
	
	
	public User(String roleName, String email, String password, String firstName, String lastName,
			Date dateCreation) {
		this.roleName = roleName;
		this.email = email;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateCreation = dateCreation;
	}


	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}
	

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	

	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	


	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}


	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public Date getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	@Override
	public String toString() {
		return "User [userid=" + userid + ", roleName=" + roleName + ", email=" + email + ", password=" + password
				+ ", firstName=" + firstName + ", lastName=" + lastName + ", dateCreation=" + dateCreation + "]";
	}
	
	
	
}
