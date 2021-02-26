package com.coin.data.json;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.coin.util.DateUtils;

@Entity
@Table(name="coin")
public class Coin {

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int coinId;

	private int id;

	@ManyToOne(fetch = FetchType.LAZY)
	private Statistic statistic;
	private String name;
	private String symbol;
	private String slug;
	private int numMarketPairs;
	private LocalDateTime dateAdded;
	private String[] tags;
	private long maxSupply;
	private long circulatingSupply;
	
	@OneToOne
	private Platform platform;
	private int cmcRank;
	private LocalDateTime lastUpdated;

	@OneToOne
	private Quote quote;

	public int getCoinId() {
		return this.coinId;
	}
	public void setCoinId(int coinId) {
		this.coinId = coinId;
	}
	public Statistic getStatistic() {
		return statistic;
	}
	public void setStatistic(Statistic statistic) {
		this.statistic = statistic;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSymbol() {
		return symbol;
	}
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	public String getSlug() {
		return slug;
	}
	public void setSlug(String slug) {
		this.slug = slug;
	}
	public int getNumMarketPairs() {
		return numMarketPairs;
	}
	public void setNumMarketPairs(int numMarketPairs) {
		this.numMarketPairs = numMarketPairs;
	}
	public LocalDateTime getDateAdded() {
		return dateAdded;
	}
	public void setDateAdded(String dateAdded) {
		this.dateAdded = DateUtils.parseJsonDateFormat(dateAdded);
	}
	public String[] getTags() {
		return tags;
	}
	public void setTags(String[] tags) {
		this.tags = tags;
	}
	public long getMaxSupply() {
		return maxSupply;
	}
	public void setMaxSupply(long maxSupply) {
		this.maxSupply = maxSupply;
	}
	public long getCirculatingSupply() {
		return circulatingSupply;
	}
	public void setCirculatingSupply(long circulatingSupply) {
		this.circulatingSupply = circulatingSupply;
	}
	public Platform getPlatform() {
		return platform;
	}
	public void setPlatform(Platform platform) {
		this.platform = platform;
	}
	public int getCmcRank() {
		return cmcRank;
	}
	public void setCmcRank(int cmcRank) {
		this.cmcRank = cmcRank;
	}
	public LocalDateTime getLastUpdated() {
		return lastUpdated;
	}
	public void setLastUpdated(String lastUpdated) {
		this.lastUpdated = DateUtils.parseJsonDateFormat(lastUpdated);
	}
	public Quote getQuote() {
		return quote;
	}
	public void setQuote(Quote quote) {
		this.quote = quote;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
}
