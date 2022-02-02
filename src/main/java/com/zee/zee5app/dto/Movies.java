package com.zee.zee5app.dto;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = "name")}, name = "movies")
public class Movies implements Comparable<Movies>{

	
	@Id
	private String id;
	
	@NotBlank
	private String name;
	
	@NotBlank
	private String genre;
	
	@NotNull
	private String releaseDate;
	
	@NotBlank
	private String language;
	
	@NotBlank
	private String cast;
	
	@NotNull
	private float length;
	
	@Max(value = 70)
	private int ageLimit;
	
	@NotBlank
	private String trailer;
	

	
	@Override
	public int compareTo(Movies o) {
		
		return this.id.compareTo(o.id);
	}


}
