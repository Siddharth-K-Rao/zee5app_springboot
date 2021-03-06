package com.zee.zee5app.dto;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity // Used for ORM Mapping
@Table(name = "register") // can customize the table name

public class Register implements Comparable<Register>{

	
	@Id  // It will consider this column as PK
	@Column(name = "regId")
	private String id; // Should have a minimum length of 6
	
	@Size(max = 50)
	@NotBlank
	private String firstName;
	
	@Size(max = 50)
	@NotBlank
	private String lastName;
	
	@Size(max = 50)
	@Email
	private String email;
	
	@Size(max = 100)
	@NotBlank
	private String password;

	@NotNull
	private BigDecimal contactNumber;
	
	@ManyToMany
	// 3rd Table
	@JoinTable(name = "user_roles", joinColumns = @JoinColumn(name = "regId"), 
	inverseJoinColumns = @JoinColumn(name = "roleId")) // registered user(regid) and role(roleid)
	private Set<Role> roles = new HashSet<Role>();
	
	@OneToOne(mappedBy = "register", cascade = CascadeType.ALL)
	private Subscription subscription;
	
	
	@Override
	public int compareTo(Register o) {
		
		//return this.id.compareTo(o.getId());
		
		// In reverse order
		return o.id.compareTo(this.getId());
	}
	
	// private stuff will be accessible only inside the class
	// To access the private variables, make use of setter and getter methods
	// setter: used to set the value for a particular field
	// getter: used to get/return the value of a specific field
	
}
