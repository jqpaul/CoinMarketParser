package com.coin.data.json;

/**
* Platform
*/
public class Platform {
	private int id;
	private String name;
	private String slug;
	private String tokenAddress;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSlug() {
		return slug;
	}
	public void setSlug(String slug) {
		this.slug = slug;
	}
	public String getTokenAddress() {
		return tokenAddress;
	}
	public void setTokenAddress(String tokenAddress) {
		this.tokenAddress = tokenAddress;
	}
}
