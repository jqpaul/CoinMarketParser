package com.coin.data.json;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.coin.util.DateUtils;
import com.google.gson.annotations.SerializedName;

@Entity
@Table(name="usd")
public class USD {

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(precision=19, scale=12)
	@SerializedName(value="price")
	private BigDecimal price;

	@Column(precision=19, scale=6)
	@SerializedName(value="volume_24h")
	private BigDecimal volume24h;

	@Column(precision=19, scale=8)
	@SerializedName(value="percent_change_1h")
	private BigDecimal percentChange1h;

	@Column(precision=19, scale=8)
	@SerializedName(value="percent_change_24h")
	private BigDecimal percentChange24h;

	@Column(precision=19, scale=8)
	@SerializedName(value="percent_change_7d")
	private BigDecimal percentChange7d;

	@Column(precision=19, scale=8)
	@SerializedName(value="percent_change_30d")
	private BigDecimal percentChange30d;

	@Column(precision=19, scale=4)
	@SerializedName(value="market_cap")
	private BigDecimal marketCap;

	@SerializedName(value="last_updated")
	private Date lastUpdated;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public BigDecimal getVolume24h() {
		return volume24h;
	}
	public void setVolume24h(BigDecimal volume24h) {
		this.volume24h = volume24h;
	}
	public BigDecimal getPercentChange1h() {
		return percentChange1h;
	}
	public void setPercentChange1h(BigDecimal percentChange1h) {
		this.percentChange1h = percentChange1h;
	}
	public BigDecimal getPercentChange24h() {
		return percentChange24h;
	}
	public void setPercentChange24h(BigDecimal percentChange24h) {
		this.percentChange24h = percentChange24h;
	}
	public BigDecimal getPercentChange7d() {
		return percentChange7d;
	}
	public void setPercentChange7d(BigDecimal percentChange7d) {
		this.percentChange7d = percentChange7d;
	}
	public BigDecimal getPercentChange30d() {
		return percentChange30d;
	}
	public void setPercentChange30d(BigDecimal percentChange30d) {
		this.percentChange30d = percentChange30d;
	}
	public BigDecimal getMarketCap() {
		return marketCap;
	}
	public void setMarketcap(BigDecimal marketCap) {
		this.marketCap = marketCap;
	}
	public Date getLastUpdated() {
		return lastUpdated;
	}
	public void setLastUpdated(String lastUpdated) {
		this.lastUpdated = DateUtils.parseJsonDateFormatToDate(lastUpdated);
	}
}
