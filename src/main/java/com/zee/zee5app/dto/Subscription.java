package com.zee.zee5app.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "subscription")
public class Subscription implements Comparable<Subscription> {
	
	
	@Id
	@Column(name = "subId")
	private String subId;
	
	@NotNull
	private String dateOfPurchase;
	
	@NotNull
	private String expiryDate;
	
	@NotBlank
	private String paymentMode;
	
	@NotBlank
	private String status;
	
	@NotBlank
	private String type;
	
	@NotNull
	private boolean autoRenewal;
	
	@NotBlank
	private String regId;
	
	@NotNull
	private float amount;

	
	
	
	@Override
	public int compareTo(Subscription o) {
		
		return this.subId.compareTo(o.subId);
	}


}
