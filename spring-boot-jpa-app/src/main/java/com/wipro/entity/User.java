package com.wipro.entity;
import java.time.LocalDate;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name = "user_entity_tab")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String username;
	private String password;
	private LocalDate birthdate;
	private String address;
	private String email;
	private Long mobile;
	
	public User() {
		
	}
	public User(Integer id, String username, String password, LocalDate birthdate, String address, String email,
			Long mobile) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.birthdate = birthdate;
		this.address = address;
		this.email = email;
		this.mobile = mobile;
	}
	public User(String username, String password, LocalDate birthdate, String address, String email,
			Long mobile) {
		super();
		
		this.username = username;
		this.password = password;
		this.birthdate = birthdate;
		this.address = address;
		this.email = email;
		this.mobile = mobile;
	}
	
	public User(Integer id, String username, String password, String birthdate, String address, String email,
			Long mobile) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.birthdate = LocalDate.parse(birthdate);
		this.address = address;
		this.email = email;
		this.mobile = mobile;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public LocalDate getBirthdate() {
		return birthdate;
	}
	public void setBirthdate(LocalDate birthdate) {
		this.birthdate = birthdate;
	}
	
	public void setBirthdate(String birthdate) {
		this.birthdate = LocalDate.parse(birthdate);
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Long getMobile() {
		return mobile;
	}
	public void setMobile(Long mobile) {
		this.mobile = mobile;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", birthdate=" + birthdate
				+ ", address=" + address + ", email=" + email + ", mobile=" + mobile + "]";
	}
	
	
	
}
