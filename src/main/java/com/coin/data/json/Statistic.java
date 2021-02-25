package com.coin.data.json;

/**
* Statistic
*/
public class Statistic {
	private Status status;
	private Coin[] data;

	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public Coin[] getData() {
		return data;
	}
	public void setData(Coin[] data) {
		this.data = data;
	}
}
