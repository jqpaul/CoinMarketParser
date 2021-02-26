package com.coin.data.json;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="quote")
public class Quote {

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@OneToOne
	private USD USD;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public USD getUSD() {
		return USD;
	}

	public void setUSD(USD USD) {
		this.USD = USD;
	}
}
