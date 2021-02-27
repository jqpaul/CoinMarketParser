package com.coin.data.json;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.coin.util.DateUtils;
import com.google.gson.annotations.SerializedName;
import com.ibm.icu.math.BigDecimal;

@Entity
@Table(name="coin")
public class Coin {

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int coinId;

	@ManyToOne(fetch = FetchType.LAZY)
	private Statistic statistic;

	@SerializedName(value="id")
	private int id;

	@SerializedName(value="name")
	private String name;

	@SerializedName(value="symbol")
	private String symbol;

	@SerializedName(value="slug")
	private String slug;

	@SerializedName(value="num_market_pairs")
	private int numMarketPairs;

	@SerializedName(value="date_added")
	private Date dateAdded;

	@ElementCollection
	@SerializedName(value="tags")
	private List<String> tags;

	@SerializedName(value="max_supply")
	private double maxSupply;

	@SerializedName(value="circulating_supply")
	private double circulatingSupply;
	
	@OneToOne
	@SerializedName(value="platform")
	private Platform platform;

	@SerializedName(value="cmc_rank")
	private int cmcRank;

	@SerializedName(value="last_updated")
	private Date lastUpdated;

	@OneToOne
	@SerializedName(value="quote")
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
	public Date getDateAdded() {
		return dateAdded;
	}
	public void setDateAdded(String dateAdded) {
		this.dateAdded = DateUtils.parseJsonDateFormatToDate(dateAdded);
	}
	public List<String> getTags() {
		return tags;
	}
	public void setTags(List<String> tags) {
		this.tags = tags;
	}
	public double getMaxSupply() {
		return maxSupply;
	}
	public void setMaxSupply(double maxSupply) {
		this.maxSupply = maxSupply;
	}
	public double getCirculatingSupply() {
		return circulatingSupply;
	}
	public void setCirculatingSupply(double circulatingSupply) {
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
	public Date getLastUpdated() {
		return lastUpdated;
	}
	public void setLastUpdated(String lastUpdated) {
		this.lastUpdated = DateUtils.parseJsonDateFormatToDate(lastUpdated);
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
