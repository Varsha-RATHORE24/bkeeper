package com.tericcabrel.authapi.entities;

import java.util.Date;

import jakarta.persistence.Entity; 
import jakarta.persistence.GeneratedValue; 
import jakarta.persistence.GenerationType; 
import jakarta.persistence.Id; 
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table; 
import lombok.AllArgsConstructor; 
import lombok.Getter; 
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor 
@Entity
@Table(name = "token")
public class TokenDetail
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id; 
	@OneToOne 
	@JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false) 
	public User user;
	private String email;
	private Date createdAt; 
	private String token; 
	private Date expirationDateFromToken;

}