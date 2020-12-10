package com.example.live.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tb_address")
@Getter
@Setter
@EqualsAndHashCode(of = { "id" })
@EntityListeners(AuditingEntityListener.class)
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "address_generator")
	@SequenceGenerator(name = "address_generator", sequenceName = "address_seq", allocationSize = 1)
	private long id;

	@Column(nullable = false)
	private String street;

	@Column(nullable = false)
	private int number;

	@Column(nullable = true)
	private String complement;

	@CreatedDate
	@Column(nullable = false, updatable = false)
	private Timestamp createAt;

	@LastModifiedDate
	@Column(nullable = false)
	private Timestamp updateAt;

}
