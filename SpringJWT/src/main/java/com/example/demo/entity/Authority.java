package com.example.demo.entity;

import org.hibernate.annotations.Table;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Data;

@Entity
@Table(appliesTo = "authority")
@Data
@Builder
public class Authority {
	
	@Id
	@Column(name = "authority_name", length = 50)
	private String authorityName;
	
}
