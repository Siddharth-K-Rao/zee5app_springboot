package com.zee.zee5app.dto;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = "name")}, name = "episodes")
public class Episodes {

	@Id
	private String id;
	
	@NotBlank
	private String seriesId;
	
	@NotBlank
	private String name;
	
	@NotNull
	private float length;
	
	@NotBlank
	private String location;
	
	@NotBlank
	private String trailer;
	
	

}
