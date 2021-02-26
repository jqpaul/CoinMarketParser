package com.coin.data.json;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="statistic")
public class Statistic {
	@Id
	@Column
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;

	@OneToOne(cascade = CascadeType.ALL)
	private Status status;

	@OneToMany(mappedBy="statistic")
	private List<Coin> data;

	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public List<Coin> getData() {
		return data;
	}
	public void setData(List<Coin> data) {
		this.data = data;
	}
}
