package com.coin.data.json;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.coin.util.DateUtils;

/**
* Usd
*/
public class Usd {
	private BigDecimal price;
	private BigDecimal volume24h;
	private BigDecimal percentChange1h;
	private BigDecimal percentChange24h;
	private BigDecimal percentChange7d;
	private BigDecimal percentChange30d;
	private BigDecimal marketCap;
	private LocalDateTime lastUpdated;

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
	public void setMarketCap(BigDecimal marketCap) {
		this.marketCap = marketCap;
	}
	public LocalDateTime getLastUpdated() {
		return lastUpdated;
	}
	public void setLastUpdated(String lastUpdated) {
		this.lastUpdated = DateUtils.parseJsonDateFormat(lastUpdated);
	}
}
